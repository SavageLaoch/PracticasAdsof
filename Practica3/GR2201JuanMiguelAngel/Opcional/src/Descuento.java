/**
 * Enumeracion de los distintos descuentos de las entradas
 * @author Juan Velasco y Miguel Angel Sanchez.
 *
 */
public enum Descuento {
  DIAESPECTADOR(50), JOVEN(20),  TERCERAEDAD(30);
/**
 * Crea un nuevo descuento
 * @param s Cantidad del descuento
 */
  private Descuento(double s){ descuento=s; }
  private final double descuento;
/**
 * Devuelve el descuento en forma de double
 * @return double con el descuento
 */
  public double getDescuento() { return descuento; }
  
}