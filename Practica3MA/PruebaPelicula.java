

public class PruebaPelicula{
  public static void main(String[] args) {
    Pelicula p1, p2;
    String titulo,director,sinopsis;
    int anno;
    Genero genero;
    p1 = new Pelicula ("Titanic","James Cameron",1997,"And thaaaaaaaaiaaaaaaa will aaalways love youuuuuuuuu",Genero.COMEDIA);
    p2 = new Pelicula ("Wolololo","Pedro Balodis",2017,"El dia que una persona fue a clase de Pedro Balodis y no volvio a ser la misma",Genero.TERROR);
    
    System.out.println("Probamos los getters en P1");
    titulo = p1.getTitulo();
    director = p1.getDirector();
    anno = p1.getAnno();
    sinopsis = p1.getSinopsis();
    genero = p1.getGenero();
    System.out.println(titulo + "\n" + director + "\n" + anno + "\n" + sinopsis + "\n" + genero + "\n");
    
    System.out.println("Probamos la funcion toString\n");
    System.out.println(p1 + "\n");
    System.out.println(p2);
    
    System.out.println("\nProbamos los setters en P2\n");
    p2.setTitulo("Matrix");
    p2.setDirector("Hermanos Wachowski");
    p2.setAnno(1999);
    p2.setSinopsis("Va este ordenador y conquista el mundo");
    p2.setGenero(Genero.CIENCIAFICCION);
    System.out.println(p2);
  }
}
