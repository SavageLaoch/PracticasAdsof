import java.util.List;

public abstract class Terminal extends Nodo {
	private Double valor = 0.0;
	
	public Terminal(String raiz) {
		super(raiz);
	}
	public void incluirDescendiente(INodo INodo) {};
	
	public List<INodo> getDescendientes(){
		return null;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double calcular() {
		return valor;
	}
	
	public double calcular(double x) {
		this.setValor(x);
		return this.calcular();
	}

	public abstract INodo copy();

}
