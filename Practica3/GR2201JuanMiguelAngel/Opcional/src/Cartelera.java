import java.util.*;
/**
 * Clase que implementa la cartelera del cine
 * @author Miguel Angel Sanchez y Juan Velasco
 *
 */
public class Cartelera{

	private List<Pelicula> peliculas;
/**
 * Constructor de la clase cartelera
 */
	public Cartelera() {
	/**
 		* Peliculas de la cartelera
 	*/
		peliculas = new ArrayList<>();
	}
/**
 * Devuelve la lista de peliculas de la cartelera
 * @return Lista de peliculas de la cartelera
 */
	public List<Pelicula> getCartelera(){
		return peliculas;
	}
/**
 * Anyade una pelicula a la  cartelera
 * @param p Pelicula a anyadir
 */
	public void addPelicula(Pelicula p) {
		peliculas.add(p);
	}
/**
 * Eliminamos una pelicula. Tendremos que comprobar fuera en cine si esta pelicula esta en la cartelera
 * @param p Pelicula a eliminar
 */
	public void removePelicula(Pelicula p) {
		peliculas.remove(p);
	}
}
