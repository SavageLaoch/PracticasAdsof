package simulador;

import java.util.*;

public abstract class Sujeto {
	protected List<Observador> observers;

	public Sujeto() {
		observers = new ArrayList<>();
	}

	public void attach(Observador o) {
		observers.add(o);
	}

	public void detach(Observador o) {
		observers.remove(o);
	}

	public void notificar() {
		Iterator<Observador> it;
		it = observers.iterator();
		while (it.hasNext())
			it.next().actualizar();
	}
}
