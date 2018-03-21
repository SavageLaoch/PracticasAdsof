import java.time.LocalDate;
/**
 * Este main comprueba todos los metodos de sesion
 * @author Miguel Angel Sanchez y Juan Velasco
 *
 */
public class PruebaSesion{
  public static void main(String[] args) {
    Pelicula p1, p;
    Sesion s1,s2;
    LocalDate d1, fecha;
    int a, b;
    String titulo,director,sinopsis;
    int anno;
    Genero genero;
/**
 * Generamos una nueva pelicula
 */
    p1 = new Pelicula ("Titanic","James Cameron",1997,"And thaaaaaaaaiaaaaaaa will aaalways love youuuuuuuuu",Genero.COMEDIA);
    d1 = LocalDate.of(1991,3,31);
    s1 = new Sesion (d1,p1,200,200);
    s2 = new Sesion (d1,p1,200,200);
/**
 * Probamos los getters en la sesion 1    
 */
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
/**
 * Probamos toString    
 */
    System.out.println("Probamos la funcion toString\n");
    System.out.println(s1 + "\n");
/**
 * Probamos los setters en sesion 2    
 */
    System.out.println("\nProbamos los setters en S2\n");
    s2.setButacasDisponibles(190);
    System.out.println(s2 + "\n");
/**    
 * Probamos a vender butacas con y sin error 
 */
    System.out.println("\nProbamos a vender butacas\n");
    if (s1.venderButacas(5)) {
    	System.out.println("Disponibles s1: " + s1.getButacasDisponibles() + " " + "Totales s1: "+ s1.getButacasTotales());
    }else {
    	System.out.println("No se han podido vender 5 butacas para s1\n");
    }
    if (s2.venderButacas(500)) {
    	System.out.println("Disponibles s2: " + s2.getButacasDisponibles() + " " + "Totales s2: " + s2.getButacasTotales());
    }else {
    	System.out.println("No se han podido vender 500 butacas en s2\n");
    }
 /**
  * Probamos a ver las butacas vendidas en sesion 1
  */
    System.out.println("\nProbamos a ver las butacas vendidas\n");
    System.out.println("Vendidas s1: " + s1.getButacasVendidas());
 /**
  * Probamos equals
  */
    System.out.println("\nProbamos el metodo equals\n");
    System.out.println("¿Son s1 y s2 iguales?\n");
    System.out.println(s1.equals(s2));
    System.out.println("\n¿Son s1 y s1 iguales?\n");
    System.out.println(s1.equals(s1));
  }
}
