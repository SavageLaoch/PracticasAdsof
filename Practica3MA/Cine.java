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

  public Entrada crearEntrada(Calendar fecha, double precio){
	/* falta comprobar la fecha y ver si es dia del espectador o no */
	Entrada e;
	e = new Entrada(precio);
	entradas.add(e);
	return e;
  }

  public Sala crearSala(int id, int butacas){
    Sala s;
    s = new Sala(id, butacas);
    salas.add(s);
    return s;
  }

  public Sesion crearSesion(LocalDate fecha, Pelicula pelicula, int butacasDisponibles, int butacasTotales, Sala sala){
    Sesion s;
    s = new Sesion(fecha,pelicula,butacasDisponibles,butacasTotales);
    sala.anyadirSesion(s);
    return s;
  }

  public Boolean venderEntrada(Sesion sesion, Calendar fecha, double precio){
    Entrada e;
    e = crearEntrada(fecha, precio);
    /*le pasamos el calendar y ella calcula el precio*/
    return sesion.venderButacas(1);
  }
  
  
}
