import java.util.*;
/**
* Definicion de la clase Profesor.
* @author Juan Velasco y Miguel Angel Sanchez.
**/

public class Profesor{
  private String dni;
  private String nombre;
  private String apellidos;
  private int telefono;
  private int seguridadSocial;
  private List<TrabajoAnterior> trabajo;

/**
* Construye un objeto de tipo Profesor con los siguientes parametros
*@param dni Dni del profesore
*@param nombre: Nombre del profesor
*@param apellidos: Apellidos del profesor
*@param telefono: Telefono del profesor
*@param seguridadSocial: numero de la seguridad social
*@param trabajo: autoescuelas en las que ha trabajado, incluyendo su periodo de trabajo
**/

public Profesor(String dni, String nombre, String apellidos,int telefono,int seguridadSocial){
    this.dni = dni;
    this.nombre = nombre;
    this.apellidos = apellids;
    this.telefono = telefono;
    this.seguridadSocial = seguridadSocial;
    trabajo = new ArrayList<TrabajoAnterior>();
  }

  /**
  * Devuelve un string con el nombre completo del profesor
  **/

  getNombreCompleto(){
    return nombre + " " + apellidos;
  }
  addTrabajoAnterior(TrabajoAnterior t){
    trabajo.add(t);
  }
  /**
  * Devuelve la lista de TrabajoAnterior con los trabajos anteriores del profesor
  **/

  getTrabajosAnteriores(){
    return trabajo;
  }
}
