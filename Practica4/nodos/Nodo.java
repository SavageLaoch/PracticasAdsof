package nodos;
import java.util.*;

public abstract class Nodo implements INodo {
	
	private String raiz;
	private List<INodo> descendientes;
	private int etiqueta;
	
	public Nodo(String raiz) {
		this.raiz = raiz;
		this.descendientes = new ArrayList<INodo>();
		this.etiqueta=-1;
	}
	
	public String getRaiz() {
		return raiz;
	}
	
	public List<INodo> getDescendientes(){
		return descendientes;
	}
	
	public void incluirDescendiente(INodo INodo) {
		descendientes.add(INodo.copy());
	}
	
	/*En el caso de un Terminal, calcular() devuelve un valor determinado*/
	public abstract double calcular();
	
	public abstract double calcular(double x);
	
	public abstract INodo copy();
	
	public String toString() {
		return "" + raiz + "";
	}
	
	public int numNodos() {
		int num = 0;
		for(INodo desc: descendientes) {
			num = num + desc.numNodos();
		}
		return num + 1;
	}
	
	public int etiquetar(int etiqueta) {
		this.etiqueta=etiqueta;
		int res = etiqueta;
		for (INodo desc:descendientes) {
			res=desc.etiquetar(res + 1);
		}
		return res;
		
	}
	public int getEtiqueta() {
		return etiqueta;
	}
	
	public INodo getNodoEtiqueta(int etiqueta) {
		INodo pivote;
		if (this.etiqueta == etiqueta) {
			return this;
		}
		for(INodo desc: descendientes) {
			pivote = desc.getNodoEtiqueta(etiqueta);
			if (pivote != null) {
				return pivote;
			}
		}
		
		return null;
	}
	
	public boolean intercambiarNodo(int etiqueta,INodo nnodo) {
		INodo pivote;
		int i;
		int cambio = -2;
		if (this.etiqueta == etiqueta) {
			return true;
		}
		for(i = 0;i < descendientes.size();i++) {
			pivote = this.descendientes.get(i);
			if(pivote.intercambiarNodo(etiqueta, nnodo)) {
				cambio = i;
				break;
			}
		}
		
		if(cambio > 0) {
			this.descendientes.remove(cambio);
			this.descendientes.add(cambio, nnodo);
		}
		return false;
	}
}
