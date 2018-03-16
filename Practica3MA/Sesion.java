import java.time.LocalDate;

/**
 * @author Juan Velasco y Miguel Angel Sanchez.
 *
 */
public class Sesion {

  private LocalDate fecha;
  private Pelicula pelicula;
  private int butacasDisponibles;
  private int butacasTotales;


  public Sesion(LocalDate fecha, Pelicula pelicula, int butacasDisponibles, int butacasTotales) {
    this.fecha=fecha;
    this.pelicula=pelicula;
    this.butacasDisponibles=butacasDisponibles;
    this.butacasTotales=butacasTotales;
  }

  public LocalDate getFecha() {return fecha;}

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
  
  public String toString(){
	    String s;
	    s = "Fecha: " + fecha + "\n";
	    s = s + "Pelicula: " + pelicula.getTitulo() + "\n";
	    s = s + "Director: " + pelicula.getDirector() + "\n";
	    s = s + "Anno: " + pelicula.getAnno() + "\n";
	    s = s + "Sinopsis: " + pelicula.getSinopsis() + "\n";
	    s = s + "Genero: " + pelicula.getGenero().getNombre() + "\n";
	    s = s + "Butacas disponibles: " + butacasDisponibles + "\n";
	    s = s + "Buatacas totales: " + butacasTotales + "\n";
	    return s;
	  }
}
