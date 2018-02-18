/**
* Definicion de la clase alumno.
* @author Juan Velasco y Miguel Angel Sanchez.
**/

public class Alumno{
  private String dni;
  private String nombre;
  private String apellidos;
  private int telefono;
  private String tipoCarnet;
  private Fecha fechaNacimiento;
  private Fecha fechaMatricula;
  private Fecha fechaTeorico;
  private Fecha fechaPractico;
  private double descuento;


  /**
  *Construye un nuevo objeto de tipo Alumno. Existen dos creadores distintos
  *dependiendo de los parametros que se le pasen.
  *@param dni DNI del alumno
  *@param nombre Nombre del alumno
  *@param apellidos Apellidos del alumno
  *@param telefono Telefono del alumno
  *@param tipoCarnet Tipo del carnet del alumno
  *@param fechaNacimiento Fecha de nacimiento del alumno
  *@param fechaMatricula Fecha de matriculacion del alumno
  *@param fechaTeorico Fecha de la realizacion del examen teorico del alumno
  *@param fechaPractico Fecha de la realizacion del examen practico del alumno
  *@param descuento Descuento del carnet del alumno (porcentaje)
  **/
  public Alumno(String dni,String nombre,String apellidos,int telefono,String tipoCarnet,Fecha fechaNacimiento, Fecha fechaMatricula, Fecha fechaTeorico, Fecha fechaPractico, double descuento){
    this.dni = dni;
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.telefono = telefono;
    this.tipoCarnet = tipoCarnet;
    this.fechaNacimiento = fechaNacimiento;
    this.fechaMatricula = fechaMatricula;
    this.fechaTeorico = fechaTeorico;
    this.fechaPractico = fechaPractico;
    this.descuento = descuento;
  }
  /**
  *Construye un nuevo objeto de tipo Alumno. Existen dos creadores distintos
  *dependiendo de los parametros que se le pasen.
  *@param dni DNI del alumno
  *@param nombre Nombre del alumno
  *@param apellidos Apellidos del alumno
  *@param anyo Año de matriculacion
  *@param mes Mes de matriculacion
  *@param dia Dia de matriculacion
  *@param tipoCarnet Tipo del carnet del alumno
  **/
  public Alumno(String dni, String nombre, String apellidos,int anyo,int mes,int dia,String tipoCarnet){
    this.dni = dni;
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.tipoCarnet = tipoCarnet;
    this.fechaMatricula = new Fecha(anyo,mes,dia);
  }
  /**
  * Devuelve la fecha de matriculacion en formato fecha
  * @return fechaMatricula
  **/
  public Fecha getFechaMatr(){
    return fechaMatricula;
  }
  /**
  *Imprime en forma de String parte de los datos de los alumnos
  *@return Cadena de caracteres con datos parciales del alumnos
  **/
  public String toString(){
    String s = "\n" + "Nombre: " + nombre + "\n" + "Apellidos: " + apellidos + "\n" + "DNI: " + dni + "\n" + "Fecha Matricula: " + fechaMatricula + "\n" + "Tipo carnet: " + tipoCarnet ;
    return s;
  }

}
