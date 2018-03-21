import java.time.LocalDate;

public class EntradaDiaEspectador extends Entrada{
  private double descuento;

  public EntradaDiaEspectador(double precio,double descuento,LocalDate fecha){
    super(precio,fecha);
    this.descuento = descuento;
  }

  public double getPrecioFinal(){
    double res;
    res = this.getPrecio()*(100 - descuento)/100;
    return res;
  }
}
