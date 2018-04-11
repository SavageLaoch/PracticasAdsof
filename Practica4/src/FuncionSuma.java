
public class FuncionSuma extends Funcion{

	public FuncionSuma(String raiz) {
		super(raiz);
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
		FuncionSuma copia = new FuncionSuma(this.getRaiz());
		for(INodo n: this.getDescendientes()) {
			copia.incluirDescendiente(n.copy());
		}
		return copia;
	}
	
}
