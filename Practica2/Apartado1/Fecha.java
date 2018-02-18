/**
* Definicion de la clase Fecha.
* @author Juan Velasco y Miguel Angel Sanchez.
**/

public class Fecha{

  private int anyo;
  private int mes;
  private int dia;

  /**
  * Construye un nuevo objeto de tipo Fecha con los parametros:
  * @param anyo Año de la fecha
  * @param mes Mes de la fecha
  * @param dia Dia de la fecha
  **/

  public Fecha (int anyo, int mes, int dia){
    this.anyo = anyo;
    this.mes = mes;
    this.dia = dia;
  }

  /**
  * Comprueba si una fecha es valida o no
  * @return True si es valida o False si no
  **/

  public boolean isFechaValida(){
    if (mes > 12 || mes < 1){
      return false;
    }

    if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
      if (dia > 31 || dia < 1){
        return false;
      }
    }

    if (mes == 4 || mes == 6 || mes == 9 || mes == 11){
      if (dia > 30 || dia < 1){
        return false;
      }
    }

    if (mes == 2){
      if (anyo%4 == 0){
        if (dia > 29 || dia < 1){
          return false;
        }
      }else{
        if (dia > 28 || dia < 1){
          return false;
        }
      }
    }
    return true;
  }

  /**
  * COnvierte a texto la fehca guardada
  * @return Fecha en formato yyyy-mm-dd
  **/
  
  public String toString(){
    String s = "";
    return s + anyo + "-" + mes + "-" + dia;
  }
}
