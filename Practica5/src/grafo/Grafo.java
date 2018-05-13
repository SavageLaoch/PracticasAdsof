package grafo;

import java.util.*;
import vertice.*;

public abstract class Grafo<T> {
	/**
	 * arcos: Mapa con los arcos del grafo vertices: Mapa con los vertices del grafo
	 */
	protected Map<Map<Integer, Integer>, Double> arcos;
	protected Map<Integer, Vertice<T>> vertices;

	/**
	 * Crea un nuevo grafo vacio
	 */
	public Grafo() {
		arcos = new HashMap<>();
		vertices = new TreeMap<>();
	}

	/**
	 * Crea y anade un vertice al grafo
	 * 
	 * @param Datos
	 *            del vertice
	 * @return Vertice creado
	 */
	public Vertice<T> addVertice(T datos) {
		Vertice<T> v = new Vertice<T>(vertices.size(), datos);
		vertices.put(vertices.size(), v);
		return v;
	}

	/**
	 * Crea y anade un vertice al grafo con un id determinado
	 * 
	 * @param id
	 *            Id
	 * @param datos
	 *            Datos del vertice
	 * @return Vertice creado
	 */
	protected Vertice<T> addVertice(int id, T datos) {
		Vertice<T> v = new Vertice<T>(id, datos);
		vertices.put(id, v);
		return v;
	}

	/**
	 * Devuelve la lista de vertices del grafo
	 * 
	 * @return Vertices del grafo
	 */
	public List<Vertice<T>> getVertices() {
		List<Vertice<T>> lista = new ArrayList<>();
		lista.addAll(vertices.values());
		return lista;
	}

	/**
	 * Devuelve el numero de vertices del grafo
	 * 
	 * @return Numero de vertices
	 */
	public int getNumVertices() {
		return vertices.size();
	}

	/**
	 * Devuelve el vertice con el id que se le pasa
	 * 
	 * @param id
	 *            Id del vertice
	 * @return Vertice
	 */
	public Vertice<T> getVertice(int id) {
		return this.vertices.get(id);
	}

	/**
	 * Anade un arco al grado
	 * 
	 * @param v1
	 *            Primer vertice
	 * @param v2
	 *            Segundo vertice
	 * @param peso
	 *            Peso del arco
	 */
	public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);

	/**
	 * Comprueba si existe un arco entre los dos vertices
	 * 
	 * @param v1
	 *            Vertice 1
	 * @param v2
	 *            Vertice 2
	 * @return True o False
	 */
	public boolean existeArco(Vertice<T> v1, Vertice<T> v2) {
		Map<Integer, Integer> key = new TreeMap<>();
		key.put(v1.getId(), v2.getId());
		return arcos.containsKey(key);
	}

	/**
	 * Devuelve el numero de arcos del grafo
	 * 
	 * @return Numero de arcos
	 */
	public int getNumArcos() {
		return arcos.size();
	}

	/**
	 * Devuelve el peso del arco entre v1 y v2
	 * 
	 * @param v1
	 *            Vertice 1
	 * @param v2
	 *            Vertice 2
	 * @return Peso del arco
	 */
	public abstract double getPesoDe(Vertice<T> v1, Vertice<T> v2);

	/**
	 * Devuelve los vecinos de el vector v
	 * 
	 * @param v
	 *            Vertice
	 * @return Lista con los vecinos de v
	 */
	public abstract List<Vertice<T>> getVecinosDe(Vertice<T> v);

	/**
	 * toString del grafo
	 */
	public String toString() {
		String res = "Vertices: \n";
		for (Vertice<T> v : this.vertices.values()) {
			res = res + v.toString() + "\n";
		}
		res = res + "Arcos: \n";
		res = res + arcos.toString();
		return res;
	}
}
