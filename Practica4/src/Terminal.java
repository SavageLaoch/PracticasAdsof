import java.util.List;

public abstract class Terminal extends Nodo {
	private Double valor;
	
	public Terminal(String raiz) {
		super(raiz);
	}
	public void incluirDescendiente(INodo INodo) {};
	
	public List<INodo> getDescendientes(){
		return null;
	}

	public double calcular() {
		return valor;
	}

	public abstract INodo copy();

}
