/**
 * 
 * @author Juan Velasco y Miguel Angel Sanchez.
 *
 */
public enum Genero {
  TERROR("TERROR"), COMEDIA("COMEDIA"),  ACCION("ACCION"), CIENCIAFICCION("CIENCIAFICCION");

  private Genero(String s){ nombre=s; }
  private final String nombre;

  public String getNombre() { return nombre; }
  
}
