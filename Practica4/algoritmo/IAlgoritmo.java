package algoritmo;
import dominio.*;
import individuo.*;
import java.util.*;
import terminal.*;
import funcion.*;
import exceptions.*;

public interface IAlgoritmo {
	public void defineConjuntoTerminales(List<Terminal> terminales);

	public void defineConjuntoFunciones(List<Funcion> funciones) throws ArgsDistintosFuncionesException;

	public void crearPoblacion();

	public List<Individuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException;

	public void crearNuevaPoblacion();

	public void ejecutar(IDominio dominio);
}
