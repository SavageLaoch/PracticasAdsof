package funcion;
import nodos.INodo;

/**
 * Clase FuncionMultiplicacion
 * @author Juan Velasco y Miguel Angel Sanchez
 *
 */
public class FuncionMultiplicacion extends Funcion{
	
	/**
	 * Crea una funcion multiplicacion
	 * @param raiz Raiz de la funcion
	 * @param numArg Numero de argumentos de la funcion
	 */
	public FuncionMultiplicacion(String raiz,int numArg) {
		super(raiz,numArg);
	}
	
	/**
	 * Calcula el resultado de la funcion
	 * @return res Resultado del calculo
	 */
	@Override
	public double calcular() {
		double res = 1;
		for(INodo n: this.getDescendientes()) {
			res = res * n.calcular();
		}
		return res;
	}
	
	/**
	 * Crea una copia de la funcion suma
	 * @return INodo copia de la funcion
	 */
	@Override
	public INodo copy() {
		FuncionMultiplicacion copia = new FuncionMultiplicacion(this.getRaiz(),this.getNumArg());
		for(INodo n: this.getDescendientes()) {
			copia.incluirDescendiente(n.copy());
		}
		return copia;
	}
	
	/**
	 * Calcula el resultado de la funcion con un parametro
	 * @return res Resultado del calculo
	 */
	@Override
	public double calcular(double x) {
		double res = 1;
		for(INodo n: this.getDescendientes()) {
			res = res * n.calcular(x);
		}
		return res;
	}
	
}