
public class FuncionMultiplicacion extends Funcion{

	public FuncionMultiplicacion(String raiz,int numArg) {
		super(raiz,numArg);
	}

	@Override
	public double calcular() {
		double res = 1;
		for(INodo n: this.getDescendientes()) {
			res = res * n.calcular();
		}
		return res;
	}

	@Override
	public INodo copy() {
		FuncionMultiplicacion copia = new FuncionMultiplicacion(this.getRaiz(),this.getNumArg());
		for(INodo n: this.getDescendientes()) {
			copia.incluirDescendiente(n.copy());
		}
		return copia;
	}

	@Override
	public double calcular(double x) {
		double res = 1;
		for(INodo n: this.getDescendientes()) {
			res = res * n.calcular(x);
		}
		return res;
	}
	
}