package grafo;

import java.util.*;
import vertice.*;

public abstract class Grafo<T> {
	/*Para los grafos no dirigidos pondremos peso=0*/
	private Map<Map<Integer,Integer>,Integer> arcos;
	protected Map<Integer,Vertice<T>> vertices;
	
	public Grafo() {
		arcos = new TreeMap<>();
		vertices = new TreeMap<>();
	}
	
	public Vertice<T> addVertice(T datos){
		Vertice<T> v = new Vertice<T>(vertices.size(),datos);
		vertices.put(vertices.size(),v);
		return v;
	}
	
	protected Vertice<T> addVertice(int id, T datos){
		Vertice<T> v = new Vertice<T>(id,datos);
		vertices.put(id,v);
		return v;
	}
	
	public List<Vertice<T>> getVertices(){
		List<Vertice<T>> lista = new ArrayList<>();
		lista.addAll(vertices.values());
		return lista;
	}
	
	public int getNumVertices() {
		return vertices.size();
	}
	
	public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);
	
	public boolean existeArco(Vertice<T> v1, Vertice<T> v2) {
		Map<Integer,Integer> key = new TreeMap<>();
		key.put(v1.getId(), v2.getId());
		return arcos.containsKey(key);
	}
	
	public int getNumArcos() {
		return arcos.size();
	}
	
	public abstract double getPesoDe(Vertice<T> v1, Vertice<T> v2);
	
	public abstract List<Vertice<T>> getVecinosDe(Vertice<T> v); // devuelve los vértices que tienen un arco con v
	// (en grafo dirigido, v ha de ser origen de los arcos)
	public String toString() {// los vértices del grafo han de presentarse ORDENADOS POR IDENTIFICADOR
		
	}
}
