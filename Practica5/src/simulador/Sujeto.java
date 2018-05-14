package simulador;

import java.util.*;

public abstract class Sujeto {
	/**
	 * observers: lista de observadores para el sujeto
	 */
	protected List<Observador> observers;

	/**
	 * Crea un nuevo sujeto
	 */
	public Sujeto() {
		observers = new ArrayList<>();
	}

	/**
	 * Anade un observador al sujeto
	 * 
	 * @param o
	 *            Observador
	 */
	public void attach(Observador o) {
		observers.add(o);
	}

	/**
	 * Elimina un observador del sujeto
	 * 
	 * @param o
	 *            Observador
	 */
	public void detach(Observador o) {
		observers.remove(o);
	}

	/**
	 * Notifica a todos los observadores de los cambios que ha habido
	 */
	public void notificar() {
		Iterator<Observador> it;
		it = observers.iterator();
		while (it.hasNext())
			it.next().actualizar();
	}
}
