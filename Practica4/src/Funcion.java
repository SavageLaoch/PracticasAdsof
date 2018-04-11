
public abstract class Funcion extends Nodo implements INodo {
	
	public Funcion(String raiz) {
		super(raiz);
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
