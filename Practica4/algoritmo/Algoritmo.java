package algoritmo;
import dominio.*;
import individuo.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import cruce.PruebaCruce;
import terminal.*;
import funcion.*;
import exceptions.*;

/**
 * Clase Algoritmo
 * @author Juan Velasco y Miguel Angel Sanchez
 *
 */
public class Algoritmo implements IAlgoritmo {
	
	private IDominio dominio;
	private List<IIndividuo> poblacion;
	
	/**
	 * Crea un algoritmo
	 */
	public Algoritmo() {
		dominio = new DominioAritmetico();
		poblacion = new ArrayList<>();
	}
	
	/**
	 * Define el conjunto de terminales del dominio del algoritmo
	 * @param terminales Conjunto de terminales a definir
	 */
	@Override
	public void defineConjuntoTerminales(List<Terminal> terminales) {
		String[] raices = new String[terminales.size()];
		for(int i = 0; i < terminales.size();i++) {
			raices[i] = terminales.get(i).getRaiz();
		}
		dominio.definirConjuntoTerminales(raices);
	}
	
	/**
	 * Define el conjunto de funciones del dominio del algoritmo
	 * @param funciones Conjunto de funciones a definir
	 */
	@Override
	public void defineConjuntoFunciones(List<Funcion> funciones) throws ArgsDistintosFuncionesException {
		int[] argumentos = new int[funciones.size()];
		String[] raices = new String[funciones.size()];
		for(int i = 0; i < funciones.size();i++) {
			argumentos[i] = funciones.get(i).getNumArg();
			raices[i] = funciones.get(i).getRaiz();
		}
		dominio.definirConjuntoFunciones(argumentos, raices);

	}

	@Override
	public void crearPoblacion() {
		Individuo individuo;
		for(int i = 0; i < 20;i++) {
			individuo = new Individuo();
			individuo.crearIndividuoAleatorio(2,dominio.getConjuntoTerminales(),dominio.getConjuntoFunciones());
			poblacion.add(individuo);
		}

	}

	@Override
	public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException {
		PruebaCruce cruce = new PruebaCruce();
		List<IIndividuo> cruces = new ArrayList<>();
		for(int i = 0; i < 9; i++) {
			cruces.addAll(cruce.cruce(prog1, prog2));
		}
		return cruces;
	}
	/*^poblaciones de 20: pasan 2 directos (elite + otro)*/
	@Override
	public void crearNuevaPoblacion() {
		IIndividuo elite,prog1,prog2;
		int directo,paso;
		List<IIndividuo> nuevaPoblacion = new ArrayList<>();
		List<IIndividuo> torneo = new ArrayList<>();
		elite = poblacion.get(0);
		for(IIndividuo cmp: poblacion) {
			if(dominio.calcularFitness(cmp) > dominio.calcularFitness(elite)) {
				elite = cmp;
			}
		}
		
		directo = (int) Math.floor(Math.random() * poblacion.size());
		while(poblacion.indexOf(elite) == directo) {
			directo = (int) Math.floor(Math.random() * poblacion.size());
		}
		/*Metemos al elite y al que va directo*/
		nuevaPoblacion.add(elite);
		nuevaPoblacion.add(poblacion.get(directo));
		/* torneo*/
		while(torneo.size() < 4) {
			paso = (int) Math.floor(Math.random() * poblacion.size());
			if(! torneo.contains(poblacion.get(paso))) {
				torneo.add(poblacion.get(paso));
			}
		}
		prog1 = torneo.get(0);
		prog2 = torneo.get(1);
		for(IIndividuo cmp: torneo) {
			if(dominio.calcularFitness(cmp) > dominio.calcularFitness(prog1)) {
				if(dominio.calcularFitness(prog1) > dominio.calcularFitness(prog2)) {
					prog2 = prog1;
					prog1 = cmp;
				}else {
					prog1 = cmp;
				}
			}else if(dominio.calcularFitness(cmp) > dominio.calcularFitness(prog2)) {
				prog2 = cmp;
			}
		}
		while (true) {
			try {
				nuevaPoblacion.addAll(this.cruce(prog1, prog2));
				break;
			} catch (CruceNuloException e) {

			}
		}
		
		poblacion = nuevaPoblacion;

	}
	
	/* gen maxima 10, fitness minimo 10*/
	@Override
	public void ejecutar(IDominio dominio) {
		this.dominio = dominio;
		this.crearPoblacion();
		try {
			dominio.definirValoresPrueba("valoresReducido.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < 10; i++) {
			for(IIndividuo in: poblacion) {
				dominio.calcularFitness(in);
			}
			for(IIndividuo in:poblacion) {
				if(in.getFitness() >= 4) {
					System.out.println("Generacion: " + i + "\nPoblacion: \n" + poblacion);
					return;
				}
			}
			this.crearNuevaPoblacion();
		}
		for(IIndividuo in: poblacion) {
			dominio.calcularFitness(in);
		}
		System.out.println("Generacion: " + 10 + "\nPoblacion: \n" + poblacion);
		return;
	}

}
