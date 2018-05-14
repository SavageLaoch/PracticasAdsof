package GOT;

public class PersonajeGOT {
	/**
	 * nombre: Nombre del personaje cas: Casa del personaje
	 */
	private String nombre;
	private String casa;

	/**
	 * Crea un nuevo personaje
	 * 
	 * @param nombre
	 *            Nombre del personaje
	 * @param casa
	 *            Casa del personaje
	 */
	public PersonajeGOT(String nombre, String casa) {
		this.nombre = nombre;
		this.casa = casa;
	}

	/**
	 * Devuelve el nombre de un personaje
	 * 
	 * @return Nombre del personaje
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Devuelve la casa de un personaje
	 * 
	 * @return Casa del personaje
	 */
	public String getCasa() {
		return casa;
	}
	
	public boolean equals(PersonajeGOT p) {
		if(this.nombre.equals(p.nombre) && this.casa.equals(p.casa)) {
			return true;
		}
		return false;
	}
	/**
	 * toString para un personaje
	 */
	public String toString() {
		return "Nombre :" + this.nombre + "\nCasa: " + this.casa + "\n";
	}
}
