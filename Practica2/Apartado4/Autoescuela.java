import java.util.*;
/**
* Definicion de la clase Autoescuela.
* @author Juan Velasco y Miguel Angel Sanchez.
**/

public class Autoescuela{
  private Integer codigo;
  private String direccion;
  private List<Profesor> profesores;

  /**
  * Construye un objeto de tipo Autoescuela con los siguientes parametros
  *@param codigo: codigo de la Autoescuela
  *@param direccion: direccion de la Autoescuela
  **/

  public Autoescuela(Integer codigo, String direccion){
    this.codigo = codigo;
    this.direccion = direccion;
    profesores = new ArrayList<Profesor>();
  }
  /**
  * Añade un profesor a la autoescuela
  **/
  public addProfesor(Profesor p){
    profesores.add(p);
  }

  public getDireccion(){
    return direccion;
  }

  public static void main(String[] args){
    Autoescuela auto1 = new Autoescuela(1,"Avenida de la felicidad");
    Autoescuela auto2 = new Autoescuela(2,"Arenal");
    Profesor antonio = new Profesor("1234615T", "Antonio", "Perez Garcia",10100101010,01010101);
    Fecha f1 = new Fecha(2004,4,2);
    Fecha f2 = new Fecha(2009,10,4);
    TrabajoAnterior t = new TrabajoAnterior(auto2,f1,f2);
    auto1.addProfesor(antonio);
    antonio.addTrabajoAnterior(t);
    if (antonio.getTrabajosAnteriores().size() == 0){
      System.our.printLn("El profesor " + antonio.getNombreCompleto() + " no ha trabajado anteriormente en ninguna autoescula");
      return;
    }
    for (Trabajo j: antonio.getTrabajosAnteriores()){
      System.out.println("El profesor " + antonio.getNombreCompleto() + " trabajo en la autoescuela " + j.getAutoescuela().getDireccion() + " desde " j.getFechaIni() + " hasta " + j.getFechaFin
    }
  }
}
