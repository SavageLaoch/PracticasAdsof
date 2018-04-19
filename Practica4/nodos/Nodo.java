package nodos;

import java.util.*;

/**
 * Clase Nodo
 * 
 * @author Juan Velasco y Miguel Angel Sanchez
 *
 */
public abstract class Nodo implements INodo {

	private String raiz;
	private List<INodo> descendientes;
	private int etiqueta;

	/**
	 * Crea un nodo a partir de su raiz
	 * 
	 * @param raiz
	 *            Raiz del nodo
	 */
	public Nodo(String raiz) {
		this.raiz = raiz;
		this.descendientes = new ArrayList<INodo>();
		this.etiqueta = -1;
	}

	/**
	 * Obtiene la raiz del nodo
	 * 
	 * @return raiz Raiz del nodo
	 */
	public String getRaiz() {
		return raiz;
	}

	/**
	 * Obtiene los descendientes del nodo
	 * 
	 * @return Lista con los descendientes del nodo
	 */
	public List<INodo> getDescendientes() {
		return descendientes;
	}

	/**
	 * Incluye un descendiente el la lista de descendientes del nodo
	 * 
	 * @param INodo
	 *            nodo a incluir
	 */
	public void incluirDescendiente(INodo INodo) {
		descendientes.add(INodo.copy());
	}

	/**
	 * Funcion calcular() que se implementara en otro sitio
	 */
	public abstract double calcular();

	/**
	 * Funcion calcular(double x) implementada en otro sitio
	 * 
	 * @param x
	 *            Valor sobre el cual calcular
	 */
	public abstract double calcular(double x);

	/**
	 * Funcion que copia un nodo, implementada en otro sitio
	 */
	public abstract INodo copy();

	/**
	 * Imprime la informacion del nodo
	 */
	public String toString() {
		return "" + raiz + "";
	}

	/**
	 * Calcula el numero de nodos que hay por debajo de este nodo
	 * 
	 * @return num Numero de nodos descendientes directos e indirectos
	 */
	public int numNodos() {
		int num = 0;
		for (INodo desc : descendientes) {
			num = num + desc.numNodos();
		}
		return num + 1;
	}

	/**
	 * Funcion que etiqueta los nodos a partir de este nodo
	 * 
	 * @param etiqueta
	 *            etiqueta
	 */
	public int etiquetar(int etiqueta) {
		this.etiqueta = etiqueta;
		int res = etiqueta;
		for (INodo desc : descendientes) {
			res = desc.etiquetar(res + 1);
		}
		return res;

	}

	/**
	 * Obtiene la etiqueta del nodo
	 * 
	 * @return etiqueta Etiqueta del nodo
	 */
	public int getEtiqueta() {
		return etiqueta;
	}

	/**
	 * Obtiene el nodo cuya etiqueta es la pasada por parametro
	 * 
	 * @param etiqueta
	 *            Etiqueta del nodo que buscamos
	 * @return INodo Nodo cuya etiqueta es la dada
	 */
	public INodo getNodoEtiqueta(int etiqueta) {
		INodo pivote;
		if (this.etiqueta == etiqueta) {
			return this;
		}
		for (INodo desc : descendientes) {
			pivote = desc.getNodoEtiqueta(etiqueta);
			if (pivote != null) {
				return pivote;
			}
		}

		return null;
	}

	/**
	 * Intercambia el nodo por un nodo pasado por parametro
	 * 
	 * @param etiqueta
	 *            Etiqueta del nodo a intercambiar
	 * @param nnodo
	 *            Nodo a intercambiar
	 * @return true o false segun si se ha podido intercambiar o no
	 */
	public boolean intercambiarNodo(int etiqueta, INodo nnodo) {
		INodo pivote;
		int i;
		int cambio = -2;
		if (this.etiqueta == etiqueta) {
			return true;
		}
		for (i = 0; i < descendientes.size(); i++) {
			pivote = this.descendientes.get(i);
			if (pivote.intercambiarNodo(etiqueta, nnodo)) {
				cambio = i;
				break;
			}
		}

		if (cambio > 0) {
			this.descendientes.remove(cambio);
			this.descendientes.add(cambio, nnodo);
		}
		return false;
	}
}
