import java.time.LocalDate;
/**
 * Suponemos que solo hay una entrada por dia
 * @author root
 *
 */
public class Entrada{

  private double precio;
  private LocalDate fecha;

  public Entrada(double precio, LocalDate fecha){
    this.precio = precio;
    this.fecha = fecha;
  };
  
  public double getPrecio() {return this.precio;}

  public double getPrecioFinal() {return this.precio;}

public LocalDate getFecha() {
	return fecha;
	}
}
