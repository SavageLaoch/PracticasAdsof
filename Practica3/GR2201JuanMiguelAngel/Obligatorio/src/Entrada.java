import java.time.LocalDate;
/**
 * Esta clase implementa las entradas del cine
 * @author Miguel Angel Sanchez y Juan Velasco
 *
 */
public class Entrada{
/**
 * Precio base de la entrada
 */
  private double precio;
/**
 * Fecha de la entrada
 */
  private LocalDate fecha;
/**
 * Crea un nuevo objeto de tipo entrada
 * @param precio Precio de la entrada
 * @param fecha Fecha de compra de la entrada
 */
  public Entrada(double precio, LocalDate fecha){
    this.precio = precio;
    this.fecha = fecha;
  };
/**
 * Devulve el precio de la entrada sin descuento
 * @return Precio de la entrada (sin descuento)
 */
  public double getPrecio() {return this.precio;}
/**
 * Devuelve el precio final de una entrada
 * @return Precio final de una entrada
 */
  public double getPrecioFinal() {return this.precio;}
/**
 * Devuelve la fecha valida para la entrada
 * @return Fecha de la entrada
 */
public LocalDate getFecha() {
	return fecha;
	}
/**
 * Compara si dos entradas son iguales
 * @param e Entrada a comparar
 * @return true o false;
 */
public Boolean equals(Entrada e) {
	if (this.precio != e.precio) {
		return false;
	}
	if (this.fecha.equals(e.fecha) == false) {
		return false;
	}
	return true;
	}
}
