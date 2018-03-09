public class Pelicula{

  private String titulo;
  private String director;
  private int anno;
  private String sinopsis;
  private Genero genero;

  public Pelicula(String titulo,String director,int anno,String sinopsis,Genero genero){
    this.titulo = titulo;
    this.director = director;
    this.anno = anno;
    this.sinopsis = sinopsis;
    this.genero = genero;
  }

  public String getTitulo() {return titulo;}

  public String getDirector() {return director;}

  public Integer getAnno() {return anno;}

  public String getSinopsis() {return sinopsis;}

  public Genero getGenero() {return genero;}

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public void setAnno(int anno) {
    this.anno = anno;
  }

  public void setSinopsis(String sinopsis) {
    this.sinopsis = sinopsis;
  }

  public void setGenero(Genero genero) {
    this.genero = genero;
  }

  public String toString(){
    String s;
    s = "Pelicula: " + titulo + "\n";
    s = s + "Director: " + director + "\n";
    s = s + "Año: " + anno + "\n";
    s = s + "Sinopsis: " + sinopsis + "\n";
    s = s + "Genero: " + genero.nombre();
    return s;
  }
}
