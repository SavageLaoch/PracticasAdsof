package simulador;

import java.util.*;
import java.util.Random;
import GOT.GrafoGOT;
import GOT.PersonajeGOT;
import vertice.Vertice;

public class SimuladorGOT extends Sujeto {
	/**
	 * grafo: grafo sobre el que simular personaje: personaje que esta siendo
	 * simulado interracciones: lista con los personajes que ha interaccionado
	 */
	private GrafoGOT grafo;
	private Vertice<PersonajeGOT> personaje;
	private List<Vertice<PersonajeGOT>> interacciones;

	/**
	 * Crea un nuevo simulador
	 * 
	 * @param grafo
	 *            Grafo sobre el que simular
	 */
	public SimuladorGOT(GrafoGOT grafo) {
		super();
		this.grafo = grafo;
		interacciones = new ArrayList<>();
	}

	/**
	 * Genera interacciones con los vecinos del personaje que se le pasa
	 * 
	 * @param nombre
	 *            Nombre del personaje sobre el que generar las interacciones
	 * @param numVeces
	 *            Numero de interacciones por cada vecino del personaje
	 */
	public void interaccion(String nombre, int numVeces) {
		this.personaje = grafo.getVertice(nombre);
		interacciones = new ArrayList<>();
		Random gen = new Random();
		List<Vertice<PersonajeGOT>> vecinos = grafo.getVecinosDe(personaje);
		double denominador = 0;
		for (Vertice<PersonajeGOT> per : vecinos) {
			denominador = denominador + grafo.getPesoDe(personaje, per);
		}
		for (int i = 0; i < numVeces; i++) {
			interacciones = new ArrayList<>();
			for (Vertice<PersonajeGOT> per : vecinos) {
				double peso = grafo.getPesoDe(personaje, per) / denominador;
				if (peso > gen.nextDouble()) {
					interacciones.add(per);
				}
			}
			this.notificar();
		}
	}

	/**
	 * Devuelve el personaje del simulador
	 * 
	 * @return Personaje
	 */
	public Vertice<PersonajeGOT> getPersonaje() {
		return personaje;
	}

	/**
	 * Devuelve la lista de interacciones
	 * 
	 * @return Lista de interacciones
	 */
	public List<Vertice<PersonajeGOT>> getInteracciones() {
		return interacciones;
	}
}
