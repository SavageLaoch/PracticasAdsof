package funcion;
import nodos.INodo;

public class FuncionSuma extends Funcion{

	public FuncionSuma(String raiz,int numArg) {
		super(raiz,numArg);
	}

	@Override
	public double calcular() {
		double res = 0;
		for(INodo n: this.getDescendientes()) {
			res = res + n.calcular();
		}
		return res;
	}

	@Override
	public INodo copy() {
		FuncionSuma copia = new FuncionSuma(this.getRaiz(),this.getNumArg());
		for(INodo n: this.getDescendientes()) {
			copia.incluirDescendiente(n.copy());
		}
		return copia;
	}

	@Override
	public double calcular(double x) {
		double res = 0;
		for(INodo n: this.getDescendientes()) {
			res = res + n.calcular(x);
		}
		return res;
	}
	
}
