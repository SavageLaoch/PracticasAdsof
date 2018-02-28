/**
* Definicion de la clase TrabajoAnterior
* @author Juan Velasco y Miguel Angel Sanchez.
**/

public class TrabajoAnterior{
  private Autoescuela autoescula;
  private Fecha fechaIni;
  private Fecha fechaFin;

  /**
  * Construye un objeto de TrabajoAnterior
  *@param autoescuela: autoescula donde ha trabajado
  *@param fechaIni: fecha de inicio del trabajo
  *@param fechaFin: fecha de fin del trabajo
  **/

  public TrabajoAnterior(Autoescuela autoescula, Fecha fechaIni, Fecha fechaFin){
    this.autoescula = autoescula;
    this.fechaIni = fechaIni;
    this.fechaFin = fechaFin;
  }

  /**
  * Devuelve el objeto autoescuela del trabajo anterior
  **/

  public getAutoescuela(){
    return autoescula;
  }

  /**
  * Devuelve la fecha de inicio del trabajo anterior
  **/

  public getFechaIni(){
    return fechaIni;
  }

  /**
  * Devuelve la fecha de fin del trabajo anterior
  **/

  public getFechaFin(){
    return getFechaFin;
  }
}
