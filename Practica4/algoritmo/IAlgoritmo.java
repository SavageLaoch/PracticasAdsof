package algoritmo;
import dominio.*;
import individuo.*;
import java.util.*;
import terminal.*;
import funcion.*;
import exceptions.*;

public interface IAlgoritmo {
	/**
	 * Define el conjunto de terminales del dominio del algoritmo
	 * @param terminales Conjunto de terminales a definir
	 */
	public void defineConjuntoTerminales(List<Terminal> terminales);
	/**
	 * Define el conjunto de funciones del dominio del algoritmo
	 * @param funciones Conjunto de funciones a definir
	 */
	public void defineConjuntoFunciones(List<Funcion> funciones) throws ArgsDistintosFuncionesException;
	/**
	 * Crea una poblacion desde 0 con profunidad 2 y 20 individuos(se puede modificar en esta funcion)
	 */
	public void crearPoblacion();
	/**
	 * Crea una lista con los individuos cruzados (18 individuos por cruce)
	 * @param prog1 Progenitor 1
	 * @param pro2 Progenitor 2
	 * @return Lista con los individuos cruzados
	 */
	public List<IIndividuo> cruce(IIndividuo prog1, IIndividuo prog2) throws CruceNuloException;
	/**
	 * Crea una nueva generacion para la poblacion.
	 * Selecciona un élite y un individuo aleatorio.
	 * Selecciona otros dos individuos para el cruce.
	 */
	public void crearNuevaPoblacion();
	/**
	 * Ejecuta el algoritmo sobre el dominio que se le pasa.
	 * Max gen = 10
	 * Fitness min = 3
	 */
	public void ejecutar(IDominio dominio);
}
