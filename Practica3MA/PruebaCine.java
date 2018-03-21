import java.time.LocalDate;
import java.util.*;

public class PruebaCine {
	public static void main(String[] args) {
		Pelicula p1,p2;
		Sesion s1,s2,s3,s4;
		LocalDate d1,d2,d3,d4;
		Sala sa1,sa2,sa3;
		Cine cine;
		
		cine = new Cine ("Cinesa","Mendez Alvaro");
		sa1= cine.crearSala(1,200);
		sa2= cine.crearSala(1,190);
		sa3= cine.crearSala(1,180);
		d1 = LocalDate.of(1991,3,31);
		d2 = LocalDate.of(1992,4,16);
		d3 = LocalDate.of(2000,4,16);
		d4 = LocalDate.of(2002,4,16);
		p1 = cine.crearPelicula("Titanic","James Cameron",1997,"And thaaaaaaaaiaaaaaaa will aaalways love youuuuuuuuu",Genero.COMEDIA);
		p2 = cine.crearPelicula("Wolololo","Pedro Balodis",2017,"El dia que una persona fue a clase de Pedro Balodis y no volvio a ser la misma",Genero.TERROR);
		s1 = cine.crearSesion(d1,p1,sa1.getButacas(),sa1.getButacas(),sa1);
		s2 = cine.crearSesion(d2,p1,sa2.getButacas(),sa2.getButacas(),sa2);
		s3 = cine.crearSesion(d3,p2,sa3.getButacas(),sa3.getButacas(),sa3);
		s4 = cine.crearSesion(d4,p2,sa3.getButacas(),sa3.getButacas(),sa3);
		
		
		
		
		
		
		s1 = new Sesion (d1,p1,sa1.getButacas(),sa1.getButacas());
		s2 = new Sesion (d2,p1,sa2.getButacas(),sa2.getButacas());
		s3 = new Sesion (d3,p2,sa3.getButacas(),sa3.getButacas());
		s4 = new Sesion (d4,p2,sa3.getButacas(),sa3.getButacas());
		
	}
}
