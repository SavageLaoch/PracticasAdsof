import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public abstract class Dominio implements IDominio {
	
	private List<Terminal> conjuntoTerminales;
	private List<Funcion> conjuntoFunciones;
	private Map<Double,Double> valores;
	
	public Dominio() {
		conjuntoTerminales = new ArrayList<Terminal>();
		conjuntoFunciones = new ArrayList<Funcion>();
		valores = new HashMap<>();
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
		String linea;
		double x = 0,y = 0;
		int i = 0;
		BufferedReader buffer = new BufferedReader(
				new InputStreamReader(
				new FileInputStream(ficheroDatos)));
		while ((linea = buffer.readLine()) != null) {
			for(String separador: linea.split(" ")) {
				if (i == 0) {
					x = Double.parseDouble(separador);
				}else {
					y = Double.parseDouble(separador);
				}
				i = i + 1;
			}
			i = 0;
			valores.put(x, y);
		}
		buffer.close();
	}
	public double calcularFitness(IIndividuo individuo) {
		double resultado = 0;
		for(double valor: valores.keySet()) {
			System.out.println("Valor: " + valor + " <-> " + "Rdo estimado: " + valores.get(valor) + " <-> " + "Rdo real: " + individuo.calcularExpresion(valor));
			if((individuo.calcularExpresion(valor) - valores.get(valor)) <= 1 && (individuo.calcularExpresion(valor) - valores.get(valor)) >= -1 ) {
				resultado = resultado + 1;
			}
		}
		return resultado;
	}
}
