

public class Fecha{

  private int anyo;
  private int mes;
  private int dia;

  public Fecha (int anyo, int mes, int dia){
    this.anyo = anyo;
    this.mes = mes;
    this.dia = dia;
  }

  public isFechaValida(){
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

public toString(){
  s = "";
  return s + anyo + "-" + mes + "-" + dia;
}
