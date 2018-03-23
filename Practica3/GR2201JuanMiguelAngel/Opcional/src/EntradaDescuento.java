import java.time.LocalDate;
/**
 * Esta clase implementa las entradas con descuento del cine
 * @author Miguel Angel Sanchez y Juan Velasco
 *
 */
public class EntradaDescuento extends Entrada{
	/**
	 * Tipo de descuento de la entrada
	 */
	private Descuento tipo;
/**
 * Constructor de una entrada con descuento
 * @param precio Precio de la entrada
 * @param fecha Fecha de la entrada
 * @param tipo Tipo de descuento de la entrada
 */
	public EntradaDescuento(double precio, LocalDate fecha, Descuento tipo) {
		super(precio, fecha);
		this.setTipo(tipo);
	}
/**
 * Getter del tipo de descuento
 * @return Tipo de descuento
 */
	public Descuento getTipo() {
		return tipo;
	}
/**
 * Setter del tipo de descuento
 * @param tipo Tipo de descuento
 */
	public void setTipo(Descuento tipo) {
		this.tipo = tipo;
	}
/**
 * Devuelve el precio final de la entrada
 * @return Precio final de la entrada
 */
	public double getPrecioFinal() {
		return this.getPrecio() - (tipo.getDescuento()*this.getPrecio())/100;
	}
}
