package grafo;

import java.util.*;

import vertice.Vertice;

public class GrafoNoDirigido<T> extends Grafo<T> {

	public abstract void addArco(Vertice<T> v1, Vertice<T> v2, double peso);
	
	public abstract double getPesoDe(Vertice<T> v1, Vertice<T> v2);
	
	public abstract List<Vertice<T>> getVecinosDe(Vertice<T> v);
}
