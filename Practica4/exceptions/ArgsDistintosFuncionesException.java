package exceptions;

/**
 * Clase ArgsDistintosFuncionesException
 * 
 * @author Juan Velasco y Miguel Angel Sanchez
 *
 */
public class ArgsDistintosFuncionesException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Crea una excepcion del tipo ArgsDistintosFuncionesException
	 */
	public ArgsDistintosFuncionesException() {
	}

	/**
	 * Imprime la informacion de la excepcion
	 */
	public String toString() {
		return "No coinciden en numero los argumentos";
	}

}
