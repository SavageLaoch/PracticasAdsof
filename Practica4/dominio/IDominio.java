package dominio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import exceptions.ArgsDistintosFuncionesException;
import funcion.Funcion;
import individuo.IIndividuo;
import terminal.Terminal;

public interface IDominio {

	/**
	 * Define el conjunto de terminales del dominio
	 * 
	 * @param terminales
	 *            Conjunto de terminales del dominio
	 * @return Lista con los terminales del dominio
	 */
	public List<Terminal> definirConjuntoTerminales(String... terminales);

	/**
	 * Define el conjunto de funciones del dominio
	 * 
	 * @param argumentos
	 *            Argumentos de las funciones
	 * @param funciones
	 *            Conjunto de funciones del dominio
	 * @return Lista con las funciones del dominio
	 */
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones)
			throws ArgsDistintosFuncionesException;

	/**
	 * Devuelve el conjnto de terminales de un dominio return Terminales del dominio
	 */
	public List<Terminal> getConjuntoTerminales();

	/**
	 * Devuelve el conjunto de funciones de un dominio retrun Funcion
	 */
	public List<Funcion> getConjuntoFunciones();

	/**
	 * Define los valores de prueba a partir del fichero
	 * 
	 * @param ficheroDatos
	 *            fichero desde el que se leen los valores
	 */
	public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException;

	/**
	 * Calcula el fitness
	 * 
	 * @param individuo
	 */
	public double calcularFitness(IIndividuo individuo);
}
