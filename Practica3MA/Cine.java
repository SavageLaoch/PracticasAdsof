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

  public Cine(String nombre,String direccion){
    this.nombre=nombre;
    this.direccion=direccion;
    peliculas = new ArrayList<>();
    salas = new ArrayList<>();
    entradas = new ArrayList<>();
  }

  public String getNombre() {return nombre;}

  public String getDireccion() {return direccion;}

  public Pelicula crearPelicula(String titulo,String director,int anno,String sinopsis,Genero genero){
    Pelicula p;
    p = new Pelicula(titulo,director,anno,sinopsis,genero);
    peliculas.add(p);
    return p;
  }

  public Entrada crearEntrada(double precio, double descuento, LocalDate fecha){
	Entrada e;
	for(Entrada ent: entradas) {
		if (ent.getFecha().equals(fecha)) {
			return null;
		}
	}
	if (descuento != 0.0) {
		e = new EntradaDiaEspectador(precio,descuento,fecha);
	}else {
		e = new Entrada(precio,fecha);
	}
	entradas.add(e);
	return e;
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

  public Entrada getEntrada(LocalDate fecha) {
	  for (Entrada e: entradas) {
		  if (e.getFecha().equals(fecha)) {
			  return e;
		  }
	  }
	  return null;
  }
  
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
  
  public Boolean removeEntrada(LocalDate fecha) {
	  for (Entrada e: entradas) {
		  if (e.getFecha().equals(fecha)) {
			  entradas.remove(e);
			  return true;
		  }
	  }
	  return false;
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
				  for (Sesion ses: s.getSesiones()) {
					  if (ses.getPelicula().equals(p)) {
						  s.getSesiones().remove(ses);
						  res = res + 1;
					  }
				  }
			  }
			  peliculas.remove(p);
			  return res;
		  }
	  }
	  return -1;
  }
  
  public HashMap<Sesion,Sala> getCartelera(LocalDate fecha){
	  HashMap<Sesion,Sala>  cartelera = new HashMap<>();
	  Sesion ses;
	  for (Sala s: salas) {
		  ses = s.getSesion(fecha);
		  if (ses != null) {
			  cartelera.put(ses,s);
		  }
	  }
	  return cartelera;
  }
  
  public HashMap<Sesion,Sala> getSesionesPelicula(String nombre){
	  HashMap<Sesion,Sala>  cartelera = new HashMap<>();
	  Pelicula p = this.getPelicula(nombre);
	  if (p == null) {
		  return cartelera;
	  }
	  for (Sala s: salas) {
		  for(Sesion ses: s.getSesiones()) {
			  if(ses.getPelicula().equals(p)) {
				  cartelera.put(ses, s);
			  }
		  }
	  }
	  return cartelera;
  }
  /**
   * Esto es valido porque no vamos a permitir vender entradas sin precio en el dia
   * @return
   */
  public double getRecaudacion() {
	  double res = 0.0;
	  int vendidas;
	  for (Sala s: salas) {
		  for (Sesion ses: s.getSesiones()) {
			  vendidas = ses.getButacasVendidas();
			  res = res + vendidas * this.getEntrada(ses.getFecha()).getPrecioFinal();
		  }
	  }
	  return res;
  }
  /** faltan vender entradas y preguntar que tienen los javis**/
  
}
