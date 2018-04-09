import java.util.*;

public class Funcion implements Nodo {
	
	private String raiz;
	private List<Nodo> descendientes;
	private int operandos;
	
	public Funcion(String raiz, int operandos) {
		super();
		this.raiz = raiz;
		this.descendientes = new ArrayList<Nodo>();
		this.operandos = operandos;
	}
	
	public String getRaiz() {
		return raiz;
	}
	
	public List<Nodo> getDescendientes() {
		return descendientes;
	}
	
	public int getOperandos() {
		return operandos;
	}
	
	public void incluirDescendiente(Nodo nodo) {
		descendientes.add(nodo);
	}
	
	/*Implementar*/
	public double calcular() {
		
	}
	
	public Nodo copy() {
		Nodo x = new Funcion(this.raiz, this.operandos);
		for (Nodo desc:descendientes){
			x.incluirDescendiente(desc);
		}
		return x;
	}
}
