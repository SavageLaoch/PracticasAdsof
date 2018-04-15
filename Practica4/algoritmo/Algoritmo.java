package algoritmo;
import dominio.*;
import individuo.*;
import java.util.*;
import terminal.*;
import funcion.*;
import exceptions.*;

/**
 * Clase Algoritmo
 * @author Juan Velasco y Miguel Angel Sanchez
 *
 */
public class Algoritmo implements IAlgoritmo {
	
	private Dominio dominio;
	private List<Individuo> poblacion;
	
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
			individuo.crearIndividuoAleatorio(8,dominio.getConjuntoTerminales(),dominio.getConjuntoFunciones());
			poblacion.add(individuo);
		}

	}

	@Override
	public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearNuevaPoblacion() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ejecutar(IDominio dominio) {
		// TODO Auto-generated method stub

	}

}
