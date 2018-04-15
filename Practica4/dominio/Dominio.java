package dominio;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import exceptions.ArgsDistintosFuncionesException;
import funcion.Funcion;
import funcion.FuncionMultiplicacion;
import funcion.FuncionResta;
import funcion.FuncionSuma;
import individuo.IIndividuo;
import terminal.Terminal;
import terminal.TerminalAritmetico;

/**
 * Clase Dominio
 * @author Juan Velasco y Miguel Angel Sanchez
 *
 */
public abstract class Dominio implements IDominio {
	
	private List<Terminal> conjuntoTerminales;
	private List<Funcion> conjuntoFunciones;
	private Map<Double,Double> valores;
	
	/**
	 * Crea un dominio
	 */
	public Dominio() {
		conjuntoTerminales = new ArrayList<Terminal>();
		conjuntoFunciones = new ArrayList<Funcion>();
		valores = new HashMap<>();
	}	
	
	/**
	 * Define el conjunto de terminales del dominio
	 * @param terminales Conjunto de terminales del dominio
	 * @return Lista con los terminales del dominio
	 */
	public List<Terminal> definirConjuntoTerminales(String... terminales){
		for (String s:terminales) {
			Terminal x = new TerminalAritmetico(s);
			conjuntoTerminales.add(x);			
		}
		return conjuntoTerminales;
	}
	
	/**
	 * Define el conjunto de funciones del dominio
	 * @param argumentos Argumentos de las funciones
	 * @param funciones Conjunto de funciones del dominio
	 * @return Lista con las funciones del dominio
	 */
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones) throws ArgsDistintosFuncionesException{
		if (funciones.length != argumentos.length) {
			ArgsDistintosFuncionesException e = new ArgsDistintosFuncionesException();
			throw e;
		}
		int i=0;
		for (String s:funciones) {
			if (s=="*") {
				Funcion x = new FuncionMultiplicacion(s,argumentos[i]);
				conjuntoFunciones.add(x);
			}else if (s=="+") {
				Funcion x = new FuncionSuma(s,argumentos[i]);
				conjuntoFunciones.add(x);
			}else if (s=="-") {
				Funcion x = new FuncionResta(s,argumentos[i]);
				conjuntoFunciones.add(x);
			}else {
				System.out.println("Hay un simbolo que no es un operando");
				return conjuntoFunciones;
			}
			i++;
		}
		return conjuntoFunciones;
	}
	
	public List<Terminal> getConjuntoTerminales(){
		return conjuntoTerminales;
	}
	public List<Funcion> getConjuntoFunciones(){
		return conjuntoFunciones;
	}
	/**
	 * Define los valores de prueba a partir del fichero
	 * @param ficheroDatos fichero desde el que se leen los valores
	 */
	public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException{
		String linea;
		double x = 0,y = 0;
		int i = 0;
		BufferedReader buffer = new BufferedReader(
				new InputStreamReader(
				new FileInputStream(ficheroDatos)));
		while ((linea = buffer.readLine()) != null) {
			for(String separador: linea.split(" ")) {
				if (i == 0) {
					x = Double.parseDouble(separador);
				}else {
					y = Double.parseDouble(separador);
				}
				i = i + 1;
			}
			i = 0;
			valores.put(x, y);
		}
		buffer.close();
	}
	
	/**
	 * Calcula el fitness
	 * @param individuo 
	 */
	public double calcularFitness(IIndividuo individuo) {
		double resultado = 0;
		for(double valor: valores.keySet()) {
			System.out.println("Valor: " + valor + " <-> " + "Rdo estimado: " + valor + " <-> " + "Rdo real: " + individuo.calcularExpresion(valores.get(valor)));
			if((individuo.calcularExpresion(valor) - valores.get(valor)) <= 1 && (individuo.calcularExpresion(valor) - valores.get(valor)) >= -1 ) {
				resultado = resultado + 1;
			}
		}
		return resultado;
	}
}
