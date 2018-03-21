/**
 * 
 * @author Juan Velasco y Miguel Angel Sanchez.
 *
 */
public enum Genero {
  TERROR("Terror"), COMEDIA("Comedia"),  ACCION("Accion"), CIENCIAFICCION("Ciencia Ficcion");

  private Genero(String s){ nombre=s; }
  private final String nombre;

  public String getNombre() { return nombre; }
  
}
