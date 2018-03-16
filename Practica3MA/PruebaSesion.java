import java.time.LocalDate;
public class PruebaSesion{
  public static void main(String[] args) {
    Pelicula p1, p;
    Sesion s1,s2;
    LocalDate d1, fecha;
    int a, b;
    String titulo,director,sinopsis;
    int anno;
    Genero genero;

    p1 = new Pelicula ("Titanic","James Cameron",1997,"And thaaaaaaaaiaaaaaaa will aaalways love youuuuuuuuu",Genero.COMEDIA);
    d1 = LocalDate.of(1991,3,31);
    s1 = new Sesion (d1,p1,200,200);
    s2 = new Sesion (d1,p1,200,200);
    
    System.out.println("Probamos los getters en S1");
    a = s1.getButacasDisponibles();
    b = s1.getButacasTotales();
    fecha = s1.getFecha();
    p = s1.getPelicula();
    titulo = p.getTitulo();
    director = p.getDirector();
    anno = p.getAnno();
    sinopsis = p.getSinopsis();
    genero = p.getGenero();
    System.out.println(fecha + "\n" + titulo + "\n" + director + "\n" + anno + "\n" + sinopsis + "\n" + genero + "\n" + a + "\n" + b + "\n");
    
    System.out.println("Probamos la funcion toString\n");
    System.out.println(s1 + "\n");
    
    System.out.println("\nProbamos los setters en S2\n");
    s2.setButacasDisponibles(300);
    System.out.println(s2 + "\n");
    
    /*System.out.println(s1);*/
  }
}
