package grafo;

import java.util.*;

import vertice.Vertice;

public class GrafoDirigido<T> extends Grafo<T> {
	
	public void addArco(Vertice<T> v1, Vertice<T> v2, double peso) {
		if ((vertices.containsKey(v1.getId())==false) || (vertices.containsKey(v2.getId())==false)){
			return;
		}
		
		Map<Integer,Integer> m1 = new TreeMap<>();
		m1.put(v1.getId(), v2.getId());
		if (arcos.containsKey(m1)==true) {
			return;
		}
		
		arcos.put(m1, peso);
	}
	
	public double getPesoDe(Vertice<T> v1, Vertice<T> v2) {
		Map<Integer,Integer> m1 = new TreeMap<>();
		m1.put(v1.getId(), v2.getId());
		
		if (arcos.containsKey(m1)==true) {
			return arcos.get(m1);
		}
		
		return -1;
	}
	
	public List<Vertice<T>> getVecinosDe(Vertice<T> v){
		List<Vertice<T>> lista = new ArrayList<>();
		for(Vertice<T> ver: super.vertices.values()) {
			if(this.existeArco(v, ver)) {
				lista.add(ver);
			}
		}
		return lista;
		
	}
}
