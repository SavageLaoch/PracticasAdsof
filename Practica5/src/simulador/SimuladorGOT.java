package simulador;

import java.util.*;
import java.util.Random;
import GOT.GrafoGOT;
import GOT.PersonajeGOT;
import vertice.Vertice;

public class SimuladorGOT extends Sujeto {
	private GrafoGOT grafo;
	private Vertice<PersonajeGOT> personaje;
	private List<Vertice<PersonajeGOT>> interacciones;
	
	public SimuladorGOT(GrafoGOT grafo) {
		super();
		this.grafo = grafo;
		interacciones = new ArrayList<>();
	}
	
	public void interaccion(String nombre,int numVeces) {
		this.personaje = grafo.getVertice(nombre);
		interacciones = new ArrayList<>();
		Random gen = new Random();
		List<Vertice<PersonajeGOT>> vecinos = grafo.getVecinosDe(personaje);
		double denominador = 0;
		for(Vertice<PersonajeGOT> per: vecinos) {
			denominador = denominador + grafo.getPesoDe(personaje, per);
		}
		for(int i = 0; i < numVeces; i++) {
			for(Vertice<PersonajeGOT> per: vecinos) {
				double peso = grafo.getPesoDe(personaje, per) / denominador;
				if(peso > gen.nextDouble()) {
					interacciones.add(per);
					this.notificar();
				}
			}
		}	
	}
	
	public Vertice<PersonajeGOT> getPersonaje(){
		return personaje;
	}
	
	public List<Vertice<PersonajeGOT>> getInteracciones(){
		return interacciones;
	}
}
