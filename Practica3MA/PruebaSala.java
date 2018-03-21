import java.time.LocalDate;
import java.util.*;

public class PruebaSala {
	public static void main(String[] args) {
		Pelicula p;
		Sesion s1,s2,s3,s4;
		LocalDate d1,d2,d3;
		Sala s;
		int a, b;
		List<Sesion> sesiones;
		
		
		s = new Sala (1,200);
		p = new Pelicula ("Titanic","James Cameron",1997,"And thaaaaaaaaiaaaaaaa will aaalways love youuuuuuuuu",Genero.COMEDIA);
		d1 = LocalDate.of(1991,3,31);
		d2 = LocalDate.of(1992,4,16);
		d3 = LocalDate.of(2000,4,16);
		s1 = new Sesion (d1,p,s.getButacas(),s.getButacas());
		s2 = new Sesion (d2,p,s.getButacas(),s.getButacas());
		s.anyadirSesion(s1);
		s.anyadirSesion(s2);
		
		System.out.println("Probamos los getters en s y vemos que se hayan anadido bien las sesiones");
		a = s.getId();
		b = s.getButacas();
		sesiones = s.getSesiones();
		System.out.println(s + "\n");
		for (Sesion sesion: sesiones){
			System.out.println("Datos de la sesion: " + "\n" + sesion);
		}
		
		System.out.println("Probamos a eliminar una sesion");
		s.eliminarSesion(s2);
		sesiones = s.getSesiones();
		System.out.println(s + "\n");
		for (Sesion sesion: sesiones){
			System.out.println("Datos de la sesion: " + "\n" + sesion);
		}
		
		System.out.println("Por ultimo probamos a escoger una sesion asignada a esta sala en una determinada fecha");
		s3 = s.getSesion(d1);
		System.out.println(s3 + "\n");		
		System.out.println("Si usasemos una fecha en la que no hay sesion");
		s4 = s.getSesion(d3);
		System.out.println(s4 + "\n");		
	}
}
