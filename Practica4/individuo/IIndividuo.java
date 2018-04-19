package individuo;

import java.util.*;

import funcion.Funcion;
import nodos.INodo;
import terminal.Terminal;

public interface IIndividuo {

	/**
	 * Obtiene la expresion de un individuo
	 * 
	 * @return INodo Expresion del individuo
	 */
	public INodo getExpresion();

	/**
	 * Fija la expresion del individuo
	 * 
	 * @param expresion
	 *            Expresion del indivudio
	 */
	public void setExpresion(INodo expresion);

	/**
	 * Obtiene el fitness del individuo
	 * 
	 * @return fitness del individuo
	 */
	public double getFitness();

	/**
	 * Fija el fitness del individuo
	 * 
	 * @param fitness
	 *            Fitness del individuo
	 */
	public void setFitness(double fitness);

	/**
	 * Crea un individuo aleatorio con la informacion dada
	 * 
	 * @param profundidad
	 *            Profundidad del individuo
	 * @param terminales
	 *            Lista de terminales del individuo
	 * @param funciones
	 *            Lista de funciones del individuo
	 */
	public void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones);

	/**
	 * Calcula la expresion del individuo
	 * 
	 * @return expresion del individuo
	 */
	public double calcularExpresion();

	/**
	 * Otra funcion que calcula la expresion del individuo pero con parametro
	 * 
	 * @return expresion del individuo
	 */
	public double calcularExpresion(double x);

	/**
	 * Obtiene el numero de nodos del individuo
	 */
	public int getNumeroNodos();

	/**
	 * Imprime la informacion del individuo
	 */
	public void writeIndividuo();

	/**
	 * Etiqueta los nodos del individuo
	 */
	public void etiquetaNodos();

	/**
	 * Calcula el numero total de nodos del individuo
	 */
	public int totalNodos();
}
