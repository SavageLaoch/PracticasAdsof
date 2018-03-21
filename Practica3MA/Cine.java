import java.time.LocalDate;
import java.util.*;

/**
 * @author Juan Velasco y Miguel Angel Sanchez.
 *
 */
public class Cine {

  private String nombre;
  private String direccion;
  private List<Pelicula> peliculas;
  private List<Sala> salas;
  private List<Entrada> entradas;

  /**
 * @param nombre
 * @param direccion
 */
public Cine(String nombre,String direccion){
    this.nombre=nombre;
    this.direccion=direccion;
    peliculas = new ArrayList<>();
    salas = new ArrayList<>();
    entradas = new ArrayList<>();
  }
  /**
   * 
   * @return
   */


  public Pelicula crearPelicula(String titulo,String director,int anno,String sinopsis,Genero genero){
    Pelicula p;
    p = new Pelicula(titulo,director,anno,sinopsis,genero);
    peliculas.add(p);
    return p;
  }

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

  public Sesion crearSesion(LocalDate fecha, Pelicula pelicula, int butacasDisponibles, int butacasTotales, Sala sala){
    Sesion s;
    s = new Sesion(fecha,pelicula,butacasDisponibles,butacasTotales);
    if (!(sala.anyadirSesion(s))) {
    	return null;
    };
    return s;
  }
  
  public String getNombre() {return nombre;}

  public String getDireccion() {return direccion;}
  
  public Sala getSala(int id) {
	  for (Sala s: salas) {
		  if (s.getId() == id) {
			  return s;
		  }
	  }
	  return null;
  }
  
  public Pelicula getPelicula(String nombre) {
	  for (Pelicula p: peliculas) {
		  if (p.getTitulo().equals(nombre)) {
			  return p;
		  }
	  }
	  return null;
  }
    
  public Boolean removeSala(int id) {
	  for (Sala s: salas) {
		  if (s.getId() == id) {
			  salas.remove(s);
			  return true;
		  }
	  }
	  return false;
  }
  
  public int removePelicula(String nombre) {
	  int res = 0;
	  
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
			  peliculas.remove(p);
			  return res;
		  }
	  }
	  return -1;
  }
  
  
  /**
   * Hay que ver la impresion como queda
   * @return
   */
  
  public String getCartelera() {
	  String res = "";
	  for (Pelicula p: peliculas) {
		  res = res + p.getTitulo() + "\n";
	  }
	  return res;
  }
  public String getSesiones() {
	  String res = "";
	  for (Sala s: salas) {
		  for (Sesion ses: s.getSesiones()) {
			  res = res + "Pelicula: " + ses.getPelicula().getTitulo() + "\nFecha: " + ses.getFecha() + "\nSala: " +  s.getId() + "\n";
		  }
	  }
	  return res;
  }
  
  public double getRecaudacion() {
	  double res = 0.0;
	  for (Entrada e: entradas) {
		  res = res + e.getPrecioFinal();
	  }
	  return res;
  }
  
	public String venderEntrada(int numero, Sesion s, double precio, double descuento) {
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

		if (descuento != 0.0) {
			for (int i = 0; i < numero; i++) {
				e = new EntradaDiaEspectador(precio, descuento, s.getFecha());
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
