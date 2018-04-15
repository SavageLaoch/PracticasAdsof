package tester;
import java.io.IOException;

import dominio.DominioAritmetico;
import dominio.IDominio;
import funcion.Funcion;
import funcion.FuncionMultiplicacion;
import funcion.FuncionResta;
import funcion.FuncionSuma;
import individuo.IIndividuo;
import individuo.Individuo;
import terminal.Terminal;
import terminal.TerminalAritmetico;

public class TesterLecturaYFitness {
	
	public static void main(String[] args) throws IOException, IOException {
		IDominio domAritm;
		double fitness;
		
		domAritm = new DominioAritmetico();
		domAritm.definirValoresPrueba("valoresReducido.txt");
		Terminal x = new TerminalAritmetico("x");
		Funcion suma = new FuncionSuma("+", 2);
		Funcion resta = new FuncionResta("-", 2);
		Funcion multi = new FuncionMultiplicacion("*", 2);
		
		multi.incluirDescendiente(x);
		multi.incluirDescendiente(x);
		suma.incluirDescendiente(multi);
		suma.incluirDescendiente(x);
		resta.incluirDescendiente(suma);
		resta.incluirDescendiente(multi);
		IIndividuo indiv = new Individuo();
		
		indiv.setExpresion(resta);
		System.out.println();
		System.out.println("INDIVIDUO");
		indiv.etiquetaNodos();
		indiv.writeIndividuo();
		System.out.println();
		
		fitness = domAritm.calcularFitness(indiv);
		System.out.println("\nFITNESS= "+fitness);
		}
}
