package dominio;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import exceptions.ArgsDistintosFuncionesException;
import funcion.Funcion;
import individuo.IIndividuo;
import terminal.Terminal;

public interface IDominio {
	
	
	public List<Terminal> definirConjuntoTerminales(String... terminales);
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones) throws ArgsDistintosFuncionesException;
	public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException;
	public double calcularFitness(IIndividuo individuo);
}
