import java.util.*;

/**
 * @author Juan Velasco y Miguel Angel Sanchez.
 *
 */
public class Sesion {

  private Calendar fecha;
  private Pelicula pelicula;
  private int butacasDisponibles;
  private int butacasTotales;


  public Sesion(Calendar fecha, Pelicula pelicula, int butacasDisponibles, int butacasTotales) {
    this.fecha=fecha;
    this.pelicula=pelicula;
    this.butacasDisponibles=butacasDisponibles;
    this.butacasTotales=butacasTotales;
  }

  public Calendar getFecha() {return fecha;}

  public Pelicula getPelicula() {return pelicula;}

  public int getButacasDisponibles() {return butacasDisponibles;}

  public int getButacasTotales() {return butacasTotales;}

  public void setButacasDisponibles(int butacasDisponibles) {
    this.butacasDisponibles=butacasDisponibles;
  }

  public Boolean venderButacas(int butacasVendidas) {
    int i;
    i=this.butacasDisponibles-butacasVendidas;
    if (i<0){
      return false;
    }else{
      this.butacasDisponibles=i;
      return true;
    }
  }
}
