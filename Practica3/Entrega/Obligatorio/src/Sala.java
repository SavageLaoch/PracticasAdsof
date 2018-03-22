import java.util.*;
import java.time.LocalDate;
/**
 * Implementacion de las salas del cine
 * @author Miguel Angel Sanchez y Juan Velasco
 *
 */
public class Sala{

    private final int id;
    private int butacas;
    private List<Sesion> sesiones;
/**
 * Crea un objeto del tipo sala. Dentro de la sala crearemos el array de sesiones vacio
 * @param id Id de la sala. Es unico y no se puede cambiar
 * @param butacas Butacas totales de la sala
 */
    public Sala(int id,int butacas){
      this.id = id;
      this.butacas = butacas;
      sesiones = new ArrayList<>();
    }
/**
 * Devuelve el id de la sala
 * @return Id de la sala
 */
    public Integer getId(){return id;}
/**
 * Devuelve el numero de butacas de la sala
 * @return Butacas de la sala
 */
    public Integer getButacas(){return butacas;}
/**
 * Devuelve la lista de sesiones de la sala
 * @return Lista de sesiones de la sala
 */
    public List<Sesion> getSesiones(){
      return sesiones;
    }
/**
 * Devuelve la sesion para una fecha concreta
 * @param fecha Fecha de la sesion
 * @return Sesion o null si no hay sesiones ese dia
 */
    public Sesion getSesion(LocalDate fecha){
      for(Sesion sesion: sesiones){
        if(sesion.getFecha().equals(fecha)){
          return sesion;
        }
      }
      return null;
    }
/**
 * Anyade una sesion a la sala
 * @param s Sesion a añadir
 * @return true si se ha anyadido concretamente o false si ya existe una sesion esa fecha
 */
    public boolean anyadirSesion(Sesion s){
      for (Sesion sesion: sesiones){
        if (sesion.getFecha().equals(s.getFecha())){
          return false;
        }
      }
      sesiones.add(s);
      return true;
    }
/**
 * Elimina una sesion de la lista de sesiones
 * @param s Sesion a eliminar
 * @return true si se ha eliminado o false si no estaba
 */
    public boolean eliminarSesion(Sesion s){
      return sesiones.remove(s);
    }
 /**
  * Compara si dos salas son iguales (ids son unicos)
  * @param s Sala a comparar
  * @return true o false
  */
    public boolean equals(Sala s) {
    	if (this.id != s.id) {
    		return false;
    	}
    	return true;
    }
/**
 * Convierte una sala a string. Imprime su id y sus butacas    
 */
    public String toString(){
        String s;
        s = "Sala: " + id + "\n";
        s = s + "ButacasTotales: " + butacas;
        return s;
      }
}
