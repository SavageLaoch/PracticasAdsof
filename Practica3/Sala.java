import java.util.*;

public class Sala{

    private int id;
    private int butacas;
    private List<Sesion> sesiones;

    public Sala(int id,int butacas){
      this.id = id;
      this.butacas = butacas;
      sesiones = new ArrayList<>;
    }

    public Integer getId(){return id}

    public Integer getButacas(){return butacas}

    public Integer setButacas(Integer butacas){
      this.butacas = butacas;
    }

    public List<Sesion> getSesiones(){
      return sesiones;
    }

    public Sesion getSesion(Date fecha){
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
}
