package GOT;

public class PersonajeGOT {
	
	private String nombre;
	private String casa;
	
	public PersonajeGOT(String nombre, String casa) {
		super();
		this.nombre = nombre;
		this.casa = casa;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCasa() {
		return casa;
	}
	
	public void setCasa(String casa) {
		this.casa = casa;
	}
	
	public String toString() {
		return "Nombre :" + this.nombre + "\nCasa: " + this.casa + "\n"; 
	}
}
