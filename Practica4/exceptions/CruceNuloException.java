package exceptions;

/**
 * Clase CruceNuloException
 * 
 * @author Juan Velasco y Miguel Angel Sanchez
 *
 */
public class CruceNuloException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Crea una excepcion del tipo CruceNuloException
	 */
	public CruceNuloException() {

	}

	/**
	 * Imprime la informacion de la excepcion
	 */
	public String toString() {
		return "No se puede hacer el cruce";
	}
}
