package simulador;

import java.util.*;

import GOT.PersonajeGOT;
import vertice.Vertice;

public class ObservadorGOT extends Observador {
	/**
	 * simulador: simulador correspondiente al observador personaje: personaje sobre
	 * el que se comprueabn los datos interacciones: mapa con las casas y el numero
	 * de interacciones con las mismas
	 */
	private SimuladorGOT simulador;
	private PersonajeGOT personaje;
	private Map<String, Integer> interacciones;

	/**
	 * Crea un nuevo observador
	 * 
	 * @param simulador
	 *            Simulador correspondiente al observador
	 * @param personaje
	 *            Personaje correspondiente al observador
	 */
	public ObservadorGOT(SimuladorGOT simulador, PersonajeGOT personaje) {
		this.simulador = simulador;
		this.personaje = personaje;
		interacciones = new HashMap<>();
	}

	/**
	 * Actualiza el estado del observador
	 */
	@Override
	public void actualizar() {
		Vertice<PersonajeGOT> sujeto = simulador.getPersonaje();
		List<Vertice<PersonajeGOT>> destino = simulador.getInteracciones();
		if (!(sujeto.getDatos().equals(personaje))) {
			return;
		}
		for (Vertice<PersonajeGOT> per : destino) {
			if (interacciones.containsKey(per.getDatos().getCasa())) {
				interacciones.put(per.getDatos().getCasa(), interacciones.get(per.getDatos().getCasa()) + 1);
			} else {
				interacciones.put(per.getDatos().getCasa(), 1);
			}
		}
	}

	/**
	 * toString para los observadores
	 */
	public String toString() {
		String res = personaje.getNombre();
		int numInteracciones = 0;
		int interaccionesCasa = 0;
		for (String casa : interacciones.keySet()) {
			numInteracciones = numInteracciones + interacciones.get(casa);
		}
		res = res + "\n Interacciones: " + numInteracciones;
		if (interacciones.get(personaje.getCasa()) != null) {
			interaccionesCasa = interacciones.get(personaje.getCasa());
		}
		res = res + "\n\tCon miembros de su casa: " + interaccionesCasa;
		res = res + "\n\tCon miembros de casa ajena: " + (numInteracciones - interaccionesCasa);
		for (String casa : interacciones.keySet()) {
			if (casa.equals(personaje.getCasa())) {
				continue;
			}
			res = res + "\n\t\t" + casa + " :" + interacciones.get(casa);
		}
		return res;
	}

}
