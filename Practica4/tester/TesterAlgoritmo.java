package tester;

import dominio.*;
import exceptions.ArgsDistintosFuncionesException;
import algoritmo.*;

public class TesterAlgoritmo {
	public static void main(String[] args) {
		Dominio dom = new DominioAritmetico();
		Algoritmo alg = new Algoritmo();
		int[] array = new int[3];
		array[0] = 2;
		array[1] = 2;
		array[2] = 2;
		try {
			dom.definirConjuntoFunciones(array, "+", "-", "*");
		} catch (ArgsDistintosFuncionesException e) {
			e.printStackTrace();
		}
		dom.definirConjuntoTerminales("x");
		alg.ejecutar(dom);
	}
}
