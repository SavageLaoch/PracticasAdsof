
public abstract class Funcion extends Nodo implements INodo {
	private int numArg;
	
	public Funcion(String raiz,int numArg) {
		super(raiz);
		this.numArg = numArg;
	}
	
	public int getNumArg() {
		return numArg;
	}
	
	public void incluirDescendiente(INodo INodo) {
		if (this.getDescendientes().size() > numArg) {
			return;
		}
		super.incluirDescendiente(INodo);
	}
	
	public abstract double calcular();
	
	public abstract INodo copy();
	
	public String toString() {
		String s = "";
		for(INodo n: this.getDescendientes()) {
			s = s + n.toString();
		}
		for(int i = 1; i < this.getDescendientes().size();i++) {
			s = this.getRaiz() + " " + s;
		}
		return "(" + s + ")"; 
	}
}
