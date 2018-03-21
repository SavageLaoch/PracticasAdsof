/**
 * Enumeracion de los distintos generos de las peliculas
 * @author Juan Velasco y Miguel Angel Sanchez.
 *
 */
public enum Genero {
  TERROR("Terror"), COMEDIA("Comedia"),  ACCION("Accion"), CIENCIAFICCION("Ciencia Ficcion");
/**
 * Crea un nuevo genero
 * @param s Nombre del genero
 */
  private Genero(String s){ nombre=s; }
  private final String nombre;
/**
 * Devuelve el genero en forma de string
 * @return String con el genero
 */
  public String getNombre() { return nombre; }
  
}
