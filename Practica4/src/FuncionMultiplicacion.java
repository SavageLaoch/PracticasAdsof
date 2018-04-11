
public class FuncionMultiplicacion extends Funcion{

	public FuncionMultiplicacion(String raiz) {
		super(raiz);
	}

	@Override
	public double calcular() {
		double res = 0;
		for(INodo n: this.getDescendientes()) {
			res = res * n.calcular();
		}
		return res;
	}

	@Override
	public INodo copy() {
		FuncionMultiplicacion copia = new FuncionMultiplicacion(this.getRaiz());
		for(INodo n: this.getDescendientes()) {
			copia.incluirDescendiente(n.copy());
		}
		return copia;
	}
	
}