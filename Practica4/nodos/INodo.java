package nodos;
import java.util.*;

public interface INodo {
	/**
	 * Obtiene la raiz del nodo
	 * @return raiz Raiz del nodo
	 */
	public String getRaiz();
	/**
	 * Obtiene los descendientes del nodo
	 * @return Lista con los descendientes del nodo
	 */
	public List<INodo> getDescendientes();
	/**
	 * Incluye un descendiente el la lista de descendientes del nodo
	 * @param INodo nodo a incluir
	 */
	public void incluirDescendiente(INodo nodo);
	/**
	 * Funcion calcular() que se implementara en otro sitio
	 */
	public double calcular();
	/**
	 * Funcion calcular(double x) implementada en otro sitio
	 * @param x Valor sobre el cual calcular
	 */
	public double calcular(double x);
	/**
	 * Funcion que copia un nodo, implementada en otro sitio
	 */
	public INodo copy();
	/**
	 * Funcion que etiqueta los nodos a partir de este nodo
	 * @param etiqueta etiqueta
	 */
	public int etiquetar(int etiqueta);
	/**
	 * Obtiene la etiqueta del nodo
	 * @return etiqueta Etiqueta del nodo
	 */
	public int getEtiqueta();
	/**
	 * Obtiene el nodo cuya etiqueta es la pasada por parametro
	 * @param etiqueta Etiqueta del nodo que buscamos
	 * @return INodo Nodo cuya etiqueta es la dada
	 */
	public INodo getNodoEtiqueta(int etiqueta);
	/**
	 * Intercambia el nodo por un nodo pasado por parametro
	 * @param etiqueta Etiqueta del nodo a intercambiar
	 * @param nnodo Nodo a intercambiar
	 * @return true o false segun si se ha podido intercambiar o no
	 */
	public boolean intercambiarNodo(int etiqueta, INodo nnodo);
	/**
	 * Calcula el numero de nodos que hay por debajo de este nodo
	 * @return num Numero de nodos descendientes directos e indirectos
	 */
	public int numNodos();
}

