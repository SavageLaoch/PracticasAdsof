import java.time.LocalDate;

/**
 * Esta clase implemetna las sesiones de las peliculas del cine
 * @author Juan Velasco y Miguel Angel Sanchez.
 *
 */
public class Sesion {
  /**
   * Fecha de la sesion
   */
  private LocalDate fecha;
  /**
   * Pelicula de la sesion
   */
  private Pelicula pelicula;
  /**
   * Butacas disponibles de la sesion
   */
  private int butacasDisponibles;
  /**
   * Butacas totales de la sesion
   */
  private int butacasTotales;

/**
 * Crea un objeto del tipo sesion
 * @param fecha Fecha de la sesion
 * @param pelicula Pelicula de la sesion
 * @param butacasTotales Butacas totales
 */
  public Sesion(LocalDate fecha, Pelicula pelicula, int butacasTotales) {
    this.fecha=fecha;
    this.pelicula=pelicula;
    this.butacasDisponibles=butacasTotales;
    this.butacasTotales=butacasTotales;
  }
/**
 * Devuelve la fecha de la sesion
 * @return Fecha de la sesion
 */
  public LocalDate getFecha() {return fecha;}
/**
 * Devuelve la pelicula de la sesion
 * @return Pelicula de la sesion
 */
  public Pelicula getPelicula() {return pelicula;}
/**
 * Devuelve las butacas disponibles
 * @return Butacas disponibles
 */
  public int getButacasDisponibles() {return butacasDisponibles;}
/**
 * Devuelve las butacas totales
 * @return Butacas totales
 */
  public int getButacasTotales() {return butacasTotales;}
/**
 * Cambia las butacas disponibles
 * @param butacasDisponibles Nuevas butacas disponibles
 * @return true si se ha podido cambiar fakse si no
 */
  public boolean setButacasDisponibles(int butacasDisponibles) {
	  if (butacasDisponibles > this.butacasTotales) {
		  return false;
	  }
	  this.butacasDisponibles=butacasDisponibles;
	  return true;
  }
/**
 * Vende las butacas
 * @param butacasVendidas Butacas a vender
 * @return true si se ha podido hacer false si no
 */
  public boolean venderButacas(int butacasVendidas) {
    int i;
    i=this.butacasDisponibles-butacasVendidas;
    if (i<0){
      return false;
    }else{
      this.butacasDisponibles=i;
      return true;
    }
  }
/**
 * Devuelve el numero de butacas vendidas
 * @return Butacas vendidas
 */
  public int getButacasVendidas() {
	  return butacasTotales - butacasDisponibles;
  }
/**
 * Compara dos sesiones
 * @param s Sesion a comparar
 * @return true o false
 */
  public boolean equals(Sesion s) {
	  if (this.pelicula.equals(s.pelicula) == false) {
		  return false;
	  }
	  if (this.fecha.equals(s.fecha) == false){
		  return false;
	  }
	  if (this.butacasDisponibles != s.butacasDisponibles) {
		  return false;
	  }
	  if (this.butacasTotales != s.butacasTotales) {
		  return false;
	  }
	  return true;
  }
/**
 * Devuelve la informacionde la sesion
 */
  public String toString(){
	    String s;
	    s = "Fecha: " + fecha + "\n";
	    s = s + pelicula;
	    s = s + "Butacas disponibles: " + butacasDisponibles + "\n";
	    s = s + "Buatacas totales: " + butacasTotales + "\n";
	    return s;
	  }
}
