package terminal;
import java.util.List;

import nodos.INodo;
import nodos.Nodo;

/**
 * Clase Terminal
 * @author Juan Velasco y Miguel Angel Sanchez
 *
 */
public abstract class Terminal extends Nodo {
	private Double valor = 0.0;
	
	/**
	 * Crea un terminal
	 * @param raiz Raiz del terminal
	 */
	public Terminal(String raiz) {
		super(raiz);
	}
	
	/**
	 * Incluye un nodo en la lista de descendientes
	 * Esta funcion no se usara porque un terminal no tiene descendientes
	 * @param INodo nodo a incluir
	 */
	public void incluirDescendiente(INodo INodo) {};
	
	/**
	 * Obtiene los descendientes de un terminal
	 * @return null porque un terminal no tiene descendientes
	 */
	public List<INodo> getDescendientes(){
		return null;
	}
	
	/**
	 * Establece el valor del terminal
	 * @param valor Valor del terminal
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	/**
	 * Obtiene el valor del terminal
	 * @return valor del terminal
	 */
	public double calcular() {
		return valor;
	}
	
	/**
	 * Funcion calcular con parametro de entrada x
	 * @return resultado
	 */
	public double calcular(double x) {
		this.setValor(x);
		return this.calcular();
	}
	
	/**
	 * Copia el nodo terminal.
	 * (Esta implementada en TerminalAritmetico)
	 */
	public abstract INodo copy();

}
