import java.time.LocalDate;
import java.util.*;

/**
 * Implementacion del cine
 * @author Juan Velasco y Miguel Angel Sanchez.
 *
 */
public class Cine {

  private String nombre;
  private String direccion;
  private Cartelera cartelera;
  private List<Sala> salas;
  private List<Entrada> entradas;

  /**
 * Crea un objeto del tipo cine. Dentro del cine creamos los arrays de peliculas, salas y entradas vacios.
 * @param nombre Nombre del cine.
 * @param direccion Direccion del cine.
 */
public Cine(String nombre,String direccion){
    this.nombre=nombre;
    this.direccion=direccion;
    cartelera = new Cartelera();
    salas = new ArrayList<>();
    entradas = new ArrayList<>();
  }

  /**
   * Crea una pelicula y la anade al cine.
   * @param titulo Titulo de la pelicula
   * @param director Director de la pelicula
   * @param anno Anno en el que se estreno la pelicula
   * @param sinopsis Breve resumen de la pelicula
   * @param genero Genero de la pelicula
   */
  public Pelicula crearPelicula(String titulo,String director,int anno,String sinopsis,Genero genero){
    Pelicula p;
    p = new Pelicula(titulo,director,anno,sinopsis,genero);
    cartelera.addPelicula(p);
    return p;
  }
  
  /**
   * Crea una sala y la anade al cine.
   * @param id Id de la sala
   * @param butacas Numero de butacas que tiene la nueva sala
   * @return Objeto Sala
   */
  public Sala crearSala(int id, int butacas){
    Sala s;
    for (Sala sala: salas) {
    	if(sala.getId() == id) {
    		return null;
    	}
    }
    s = new Sala(id, butacas);
    salas.add(s);
    return s;
  }
  
  /**
   * Crea una sesion y la anade al cine
   * @param fecha Fecha de la sesion
   * @param pelicula Pelicula de la sesion
   * @param sala Sala en la que sera la sesion
   * @return Objeto Sesion
   */
  public Sesion crearSesion(LocalDate fecha, Pelicula pelicula, Sala sala){
    Sesion s;
    s = new Sesion(fecha,pelicula,sala.getButacas());
    if (!(sala.anyadirSesion(s))) {
    	return null;
    };
    return s;
  }
  
  /**
   * Obtiene el nombre del cine
   * @return Nombre del cine
   */
  public String getNombre() {return nombre;}
  
  /**
   * Obtiene la direccion del cine
   * @return Direccion del cine
   */
  public String getDireccion() {return direccion;}
  
  /**
   * Obtiene la sala con un id determinado
   * @param id Id de la sala a obtener
   * @return Objeto Sala
   */
  public Sala getSala(int id) {
	  for (Sala s: salas) {
		  if (s.getId() == id) {
			  return s;
		  }
	  }
	  return null;
  }
  
  /**
   * Obtiene una pelicula con un nombre determinado
   * @param nombre Nombre de la pelicula
   * @return Objeto Pelicula
   */
  public Pelicula getPelicula(String nombre) {
	  List<Pelicula> peliculas = cartelera.getCartelera();
	  for (Pelicula p: peliculas) {
		  if (p.getTitulo().equals(nombre)) {
			  return p;
		  }
	  }
	  return null;
  }
  
  /**
   * Borra una sala del cine
   * @param id Id de la sala a borrar
   * @return true si se ha podido borrar, false si no
   */
  public Boolean removeSala(int id) {
	  for (Sala s: salas) {
		  if (s.getId() == id) {
			  salas.remove(s);
			  return true;
		  }
	  }
	  return false;
  }
  
  /**
   * Borra una pelicula del cine
   * @param nombre Nombre de la pelicula a borrar
   * @return el numero de sesiones que se han eliminado
   */
  public int removePelicula(String nombre) {
	  int res = 0;
	  List<Pelicula> peliculas = cartelera.getCartelera();
	  for (Pelicula p: peliculas) {
		  if (p.getTitulo().equals(nombre)) {
			  for (Sala s: salas) {
				  List<Sesion> puente = new ArrayList<>();
				  for (Sesion ses: s.getSesiones()) {
					  if (ses.getPelicula().equals(p)) {
						  puente.add(ses);
						  res = res + 1;
					  }
				  }
				  for (Sesion ses: puente) {
					  s.getSesiones().remove(ses);
				  }
			  }
			  cartelera.removePelicula(p);
			  return res;
		  }
	  }
	  return -1;
  }
  
  
  /**
   * Obtiene la cartelera del cine
   * @return string con todas las peliculas que hay en el cine
   */  
  public String getCartelera() {
	  String res = "";
	  List<Pelicula> peliculas = cartelera.getCartelera();
	  for (Pelicula p: peliculas) {
		  res = res + p.getTitulo() + "\n";
	  }
	  return res;
  }
  
  /**
   * Obtiene las sesiones del cina
   * @return string con alguna informacion de cada sesion
   */
  public String getSesiones() {
	  String res = "";
	  for (Sala s: salas) {
		  for (Sesion ses: s.getSesiones()) {
			  res = res + "Pelicula: " + ses.getPelicula().getTitulo() + "\nFecha: " + ses.getFecha() + "\nSala: " +  s.getId() + "\n";
		  }
	  }
	  return res;
  }
  
  /**
   * Obtiene el dinero recaudado con las entradas vendidas
   * @return Dinero recaudado
   */
  public double getRecaudacion() {
	  double res = 0.0;
	  for (Entrada e: entradas) {
		  res = res + e.getPrecioFinal();
	  }
	  return res;
  }
  
  	/**
  	 * Crea entradas y las anade al array de entradas del cine
  	 * @param numero Numero de entradas que se venden
  	 * @param s Sesion para la que se venden las entradas
  	 * @param precio Precio de cada entrada
  	 * @param descuento Descuento de cada entrada
  	 * @return mensajes de error si no se han podido vender o la informacion de la sesion y de la venta si si se han podido vender
  	 */
	public String venderEntrada(int numero, Sesion s, double precio, Descuento descuento) {
		Entrada e;
		String res;
		Sesion ses;
		Sala sala = null;
		double preciofinal = 0;
		for (Sala sal : salas) {
			ses = sal.getSesion(s.getFecha());
			if (ses != null) {
				if (ses.equals(s)) {
					sala = sal;
					break;
				}
			}
		}
		if (sala == null) {
			res = "No existe la sesion";
			return res;
		}

		if (s.venderButacas(numero) == false) {
			res = "No hay suficientes butacas";
			return res;
		}

		if (descuento != null) {
			for (int i = 0; i < numero; i++) {
				e = new EntradaDescuento(precio,s.getFecha(),descuento);
				preciofinal = e.getPrecioFinal();
				entradas.add(e);
			}
		} else {
			for (int i = 0; i < numero; i++) {
				e = new Entrada(precio, s.getFecha());
				preciofinal = e.getPrecioFinal();
				entradas.add(e);
			}
		}
		res = "Pelicula: " + s.getPelicula().getTitulo() + "\nFecha: " + s.getFecha() + "\nSala: " +  sala.getId() + "\nNumero de butacas vendidas: " + numero +  "\nPrecio por butaca: " + preciofinal + "\nPrecio total: " + numero * preciofinal;
		return res;
	}
  
  
}
