package main;

import simulador.*;

import java.util.*;

import GOT.*;


public class MainApartado3 {
	public static void main(String args[]) throws Exception {
		GrafoGOT grafo = new GrafoGOT("got-s01-vertices.csv", "got-s01-arcos.csv");
		SimuladorGOT simulador = new SimuladorGOT(grafo);
		List<String> personajes = new ArrayList<>(grafo.gradoPersonajes().keySet());
		ObservadorGOT observador1 = new ObservadorGOT(simulador,grafo.getVertice(89).getDatos());
		ObservadorGOT observador2 = new ObservadorGOT(simulador,grafo.getVertice(155).getDatos());
		int N = 10000;
		
		simulador.attach(observador1);
		simulador.attach(observador2);
		for(int i = 0; i < N; i++) {
			simulador.interaccion(personajes.get((int) (Math.random() * (personajes.size()))), 10);
		}
		
		System.out.println(observador1);
		System.out.println(observador2);

	}
}
