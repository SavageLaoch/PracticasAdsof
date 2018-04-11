import java.util.*;

public abstract class Nodo implements INodo {
	
	private String raiz;
	private List<INodo> descendientes;
	
	public Nodo(String raiz) {
		this.raiz = raiz;
		this.descendientes = new ArrayList<INodo>();
	}
	
	public String getRaiz() {
		return raiz;
	}
	
	public List<INodo> getDescendientes(){
		return descendientes;
	}
	
	public void incluirDescendiente(INodo INodo) {
		descendientes.add(INodo);
	}
	
	/*En el caso de un Terminal, calcular() devuelve un valor determinado*/
	public abstract double calcular();
	
	public abstract INodo copy();
	
	public String toString() {
		return "" + raiz + "";
	}

}
