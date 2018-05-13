package simulador;

import java.util.*;
import java.util.Random;
import GOT.GrafoGOT;
import GOT.PersonajeGOT;
import vertice.Vertice;

public class SimuladorGOT extends Sujeto {
	private GrafoGOT grafo;
	private Vertice<PersonajeGOT> personaje;
	private Map<String,Integer> interacciones;
	
	public SimuladorGOT(GrafoGOT grafo) {
		super();
		this.grafo = grafo;
	}
	
	public void interaccion(String nombre,int numVeces) {
		this.personaje = grafo.getVertice(nombre);
		interacciones = new HashMap<>();
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
					if(interacciones.containsKey(per.getDatos().getCasa())) {
						interacciones.put(per.getDatos().getCasa(), interacciones.get(per.getDatos().getCasa()) + 1);
					}else {
						interacciones.put(per.getDatos().getCasa(),1);
					}
					this.notificar();
				}
			}
		}
		
	}
}
