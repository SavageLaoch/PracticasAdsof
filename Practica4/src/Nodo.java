import java.util.*;

public interface Nodo {
	
	
	public String getRaiz();
	public List<Nodo> getDescendientes();
	public void incluirDescendiente(Nodo nodo);
	public double calcular();
	public Nodo copy();
}

