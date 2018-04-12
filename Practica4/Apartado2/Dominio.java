import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public abstract class Dominio implements IDominio {
	
	private List<Terminal> conjuntoTerminales;
	private List<Funcion> conjuntoFunciones;
	
	public Dominio() {
		conjuntoTerminales = new ArrayList<Terminal>();
		conjuntoFunciones = new ArrayList<Funcion>();
	}	
	
	public List<Terminal> definirConjuntoTerminales(String... terminales){
		for (String s:terminales) {
			Terminal x = new TerminalAritmetico(s);
			conjuntoTerminales.add(x);			
		}
		return conjuntoTerminales;
	}
	
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones) throws ArgsDistintosFuncionesException{
		if (funciones.length != argumentos.length) {
			ArgsDistintosFuncionesException e = new ArgsDistintosFuncionesException();
			throw e;
		}
		int i=0;
		for (String s:funciones) {
			if (s=="*") {
				Funcion x = new FuncionMultiplicacion(s,argumentos[i]);
				conjuntoFunciones.add(x);
			}else if (s=="+") {
				Funcion x = new FuncionSuma(s,argumentos[i]);
				conjuntoFunciones.add(x);
			}else if (s=="-") {
				Funcion x = new FuncionResta(s,argumentos[i]);
				conjuntoFunciones.add(x);
			}else {
				System.out.println("Hay un simbolo que no es un operando");
				return conjuntoFunciones;
			}
			i++;
		}
		return conjuntoFunciones;
	}
	
	public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException{
		
	}
	public double calcularFitness(IIndividuo individuo) {
		
	}
}
