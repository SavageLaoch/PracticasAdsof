package terminal;
import nodos.INodo;

/**
 * Clase terminal aritmetico
 * @author Juan Velasco y Miguel Angel Sanchez
 *
 */
public class TerminalAritmetico extends Terminal{
	
	/**
	 * Crea un terminal aritmetico
	 * @param raiz Raiz del terminal
	 */
	public TerminalAritmetico(String raiz) {
		super(raiz);
	}
	
	/**
	 * Crea una copia un nodo del tipo TerminalAritmetico
	 * @return INodo resultante de la copia
	 */
	public INodo copy() {
		Terminal t = new TerminalAritmetico(this.getRaiz());
		return t;
	}

}
