package main;

import GOT.GrafoGOT;

public class MainApartado2 {
	public static void main(String args[]) throws Exception {
		GrafoGOT grafo = new GrafoGOT("got-s01-vertices.csv", "got-s01-arcos.csv");
		System.out.println("Grafo: \n" + grafo + "\n");
		System.out.println("Casas: \n");
		grafo.casas().stream().forEach(System.out::println);
		System.out.println("\nPersonajes de la casa " + grafo.casas().get(0) + ": \n");
		grafo.miembrosCasa(grafo.casas().get(0)).stream().forEach(System.out::println);
		System.out.println("\nGrado de los personajes: \n");
		grafo.gradoPersonajes().keySet().stream().forEach((p) -> {
			System.out.println("Personaje: " + p + " Grado: " + grafo.gradoPersonajes().get(p));
		});
		System.out.println("\nGrado ponderado de los personajes: \n");
		grafo.gradoPonderadoPersonajes().keySet().stream().forEach((p) -> {
			System.out.println("Personaje: " + p + " Grado: " + grafo.gradoPonderadoPersonajes().get(p));
		});
		System.out.println("\nGrado ponderado de los personajes relevantes: \n");
		grafo.personajesRelevantes().keySet().stream().forEach((p) -> {
			System.out.println("Personaje: " + p + " Grado: " + grafo.personajesRelevantes().get(p));
		});
	}
}
