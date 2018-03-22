import java.util.*;
public class PruebaSesion{
  public static void main(String[] args) {
    Pelicula p1, p2;
    Sesion s1,s2;
    Calendar c1;

    p1 = new Pelicula ("Titanic","James Cameron",1997,"And thaaaaaaaaiaaaaaaa will aaalways love youuuuuuuuu",Genero.COMEDIA);
    p2 = new Pelicula ("Wolololo","Pedro Balodis",2017,"El dia que una persona fue a clase de Pedro Balodis y no volvio a ser la misma",Genero.TERROR);
    /*c1 = new Calendar ();*/
    c1.set(1999,3,31);
    s1 = new Sesion (c1,p1,200,200);
    System.out.println(s1);
  }
}
