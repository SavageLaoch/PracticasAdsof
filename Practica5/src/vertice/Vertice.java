package vertice;

public class Vertice<T> {
	 private final int id; // identificador del v�rtice dentro del grafo
	 private T datos; // datos almacenados en el v�rtice
	 
	 public Vertice(int id1,T datos){
		 this.id = id1;
		 this.datos = datos;
	 }

	public int getId() {
		return id;
	}

	public T getDatos() {
		return datos;
	}
	
	public String toString() {
		return "Vertice: \n" + id + " " + datos.toString();
	}
} 
