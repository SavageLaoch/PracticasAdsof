import java.time.LocalDate;
/**
 * Clase que hereda de entrada de entrada y que implementa las entradas del dia del epectador
 * del cine
 * @author Miguel Angel Sanchez y Juan Velasco
 *
 */
public class EntradaDiaEspectador extends Entrada{
/**
 * Descuento de la entrada
*/
  private double descuento;
/**
 * Crea un objeto del tipo EntradaDiaEspectador
 * @param precio Precio de la entrada
 * @param descuento Descuento del dia del especatador
 * @param fecha Fecha de la validez de la entrada
 */
  public EntradaDiaEspectador(double precio,double descuento,LocalDate fecha){
    super(precio,fecha);
    this.descuento = descuento;
  }
/**
 * Devuelve el precio final (con el descuento aplicado) de la entrada
 * @return Precio final de la entrada
 */
  public double getPrecioFinal(){
    double res;
    res = this.getPrecio()*(100 - descuento)/100;
    return res;
  }
  /**
   * Compara si dos entradas son iguales
   * @param e Entrada a comparar
   * @return true o false;
   */
  public Boolean equals(EntradaDiaEspectador e) {
  	if (super.equals(e) == false) {
  		return false;
  	}
  	if (this.descuento != e.descuento) {
  		return false;
  	}
  	return true;
  	}
}
