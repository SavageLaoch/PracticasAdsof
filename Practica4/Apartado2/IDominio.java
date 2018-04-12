import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public interface IDominio {
	
	
	public List<Terminal> definirConjuntoTerminales(String... terminales);
	public List<Funcion> definirConjuntoFunciones(int[] argumentos, String... funciones) throws ArgsDistintosFuncionesException;
	public void definirValoresPrueba(String ficheroDatos) throws FileNotFoundException, IOException;
	public double calcularFitness(IIndividuo individuo);
}
