package funcion;

import nodos.INodo;

/**
 * Clase FuncionResta
 * 
 * @author Juan Velasco y Miguel Angel Sanchez
 *
 */
public class FuncionResta extends Funcion {

	/**
	 * Crea una funcion resta
	 * 
	 * @param raiz
	 *            Raiz de la funcion
	 * @param numArg
	 *            Numero de argumentos de la funcion
	 */
	public FuncionResta(String raiz, int numArg) {
		super(raiz, numArg);
	}

	/**
	 * Calcula el resultado de la funcion
	 * 
	 * @return res Resultado del calculo
	 */
	@Override
	public double calcular() {
		double res = 0;
		int i = 0;
		for (INodo n : this.getDescendientes()) {
			if (i == 0) {
				res = n.calcular();
			} else {
				res = res - n.calcular();
			}
			i = i + 1;
		}
		return res;
	}

	/**
	 * Crea una copia de la funcion suma
	 * 
	 * @return INodo copia de la funcion
	 */
	@Override
	public INodo copy() {
		FuncionResta copia = new FuncionResta(this.getRaiz(), this.getNumArg());
		for (INodo n : this.getDescendientes()) {
			copia.incluirDescendiente(n.copy());
		}
		return copia;
	}

	/**
	 * Calcula el resultado de la funcion con un parametro
	 * 
	 * @return res Resultado del calculo
	 */
	@Override
	public double calcular(double x) {
		double res = 0;
		int i = 0;
		for (INodo n : this.getDescendientes()) {
			if (i == 0) {
				res = n.calcular(x);
			} else {
				res = res - n.calcular(x);
			}
			i = i + 1;
		}
		return res;
	}

}