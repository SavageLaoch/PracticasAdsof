import java.util.*;

public class Terminal implements Nodo {
	
	private String raiz;
	private List<Nodo> descendientes;
	
	public Terminal(String raiz) {
		super();
		this.raiz = raiz;
		this.descendientes = new ArrayList<Nodo>();
	}
	
	public String getRaiz() {
		return raiz;
	}
	
	public List<Nodo> getDescendientes(){
		return descendientes;
	}
	
	public void incluirDescendiente(Nodo nodo) {
		descendientes.add(nodo);
	}
	
	/*En el caso de un Terminal, calcular() devuelve un valor determinado*/
	public double calcular() {
		return 43.0;
	}
	
	
	public Nodo copy() {
		Nodo x = new Terminal(this.raiz);
		for (Nodo desc:descendientes){
			x.incluirDescendiente(desc);
		}
		return x;
	}

}
