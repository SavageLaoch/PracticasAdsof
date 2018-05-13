package vertice;

public class Vertice<T> {
	/**
	 * id: Id del vertice datos: datos del vertice
	 */
	private final int id;
	private T datos;

	/**
	 * Crea un nuevo vertice
	 * 
	 * @param id1
	 *            Id del vertice
	 * @param datos
	 *            Datos del vertice
	 */
	public Vertice(int id1, T datos) {
		this.id = id1;
		this.datos = datos;
	}

	/**
	 * Devuelve el id del vertice
	 * 
	 * @return Id del vertice
	 */
	public int getId() {
		return id;
	}

	/**
	 * Devuelve los datos del vertice
	 * 
	 * @return Datos del vertice
	 */
	public T getDatos() {
		return datos;
	}

	/**
	 * toString del vertice
	 */
	public String toString() {
		return "Vertice: \n" + id + " " + datos.toString();
	}
}
