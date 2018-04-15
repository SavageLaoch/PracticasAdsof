package individuo;
import java.util.*;

import funcion.Funcion;
import nodos.INodo;
import terminal.Terminal;

public interface IIndividuo {
	
	
	public INodo getExpresion();
	public void setExpresion(INodo expresion);	
	public double getFitness();
	public void setFitness(double fitness);	
	public void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones);
	public double calcularExpresion();
	public double calcularExpresion(double x);
	public int getNumeroNodos();
	public void writeIndividuo();
	public void etiquetaNodos();
}
