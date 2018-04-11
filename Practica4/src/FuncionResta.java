
public class FuncionResta extends Funcion{

	public FuncionResta(String raiz,int numArg) {
		super(raiz,numArg);
	}

	@Override
	public double calcular() {
		double res = 0;
		for(INodo n: this.getDescendientes()) {
			res = res - n.calcular();
		}
		return res;
	}

	@Override
	public INodo copy() {
		FuncionResta copia = new FuncionResta(this.getRaiz(),this.getNumArg());
		for(INodo n: this.getDescendientes()) {
			copia.incluirDescendiente(n.copy());
		}
		return copia;
	}
	
}