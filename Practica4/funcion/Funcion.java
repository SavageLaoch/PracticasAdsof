package funcion;

import nodos.INodo;
import nodos.Nodo;

/**
 * Clase Funcion
 * 
 * @author Juan Velasco y Miguel Angel Sanchez
 *
 */
public abstract class Funcion extends Nodo implements INodo {
	private int numArg;

	/**
	 * Crea una funcion
	 * 
	 * @param raiz
	 *            Raiz de la funcion
	 * @param numArg
	 *            Numero de argumentos de la funcion
	 */
	public Funcion(String raiz, int numArg) {
		super(raiz);
		this.numArg = numArg;
	}

	/**
	 * Obtiene el numero de argumentos de la funcion
	 * 
	 * @return Numero de argumentos
	 */
	public int getNumArg() {
		return numArg;
	}

	/**
	 * Incluye un descendiente en la funcion
	 * 
	 * @param INodo
	 *            Descendiente a incluir
	 */
	public void incluirDescendiente(INodo INodo) {
		if (this.getDescendientes().size() > numArg) {
			return;
		}
		super.incluirDescendiente(INodo);
	}

	/**
	 * Funcion calcular implementada en otro sitio
	 */
	public abstract double calcular();

	/**
	 * Funcion copiar implementada en otro sitio
	 */
	public abstract INodo copy();

	/**
	 * Imprime la informacion de la funcion
	 */
	public String toString() {
		String s = "";
		for (INodo n : this.getDescendientes()) {
			s = s + " " + n.toString();
		}
		for (int i = 1; i < this.getDescendientes().size(); i++) {
			s = this.getRaiz() + " " + s;
		}
		return "( " + s + " )";
	}
}
