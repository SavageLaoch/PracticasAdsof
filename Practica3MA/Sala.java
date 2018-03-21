import java.util.*;
import java.time.LocalDate;
public class Sala{

    private final int id;
    private int butacas;
    private List<Sesion> sesiones;

    public Sala(int id,int butacas){
      this.id = id;
      this.butacas = butacas;
      sesiones = new ArrayList<>();
    }

    public Integer getId(){return id;}

    public Integer getButacas(){return butacas;}

    public List<Sesion> getSesiones(){
      return sesiones;
    }

    public Sesion getSesion(LocalDate fecha){
      for(Sesion sesion: sesiones){
        if(sesion.getFecha().equals(fecha)){
          return sesion;
        }
      }
      return null;
    }

    public Boolean anyadirSesion(Sesion s){
      for (Sesion sesion: sesiones){
        if (sesion.getFecha().equals(s.getFecha())){
          return false;
        }
      }
      sesiones.add(s);
      return true;
    }

    public Boolean eliminarSesion(Sesion s){
      return sesiones.remove(s);
    }
    
    public String toString(){
        String s;
        s = "Sala: " + id + "\n";
        s = s + "ButacasTotales: " + butacas;
        return s;
      }
}
