/**
 * Esta clase implementa las peliculas que seran proyectadas en el cine
 * @author Miguel Angel Sanchez y Juan Velasco
 *
 */
public class Pelicula{

  private String titulo;
  private String director;
  private int anno;
  private String sinopsis;
  private Genero genero;
/**
 * Constructor de la clase pelicula 
 * @param titulo Titulo de la peliucla
 * @param director Director de la pelicula
 * @param anno Annio de estreno de la pelicula
 * @param sinopsis Sinopsis de la pelicula
 * @param genero Genero de la pelicula
 */
  public Pelicula(String titulo,String director,int anno,String sinopsis,Genero genero){
    this.titulo = titulo;
    this.director = director;
    this.anno = anno;
    this.sinopsis = sinopsis;
    this.genero = genero;
  }
/**
 * Devuelve el titulo de una pelicula
 * @return Titulo de la pelicula
 */
  public String getTitulo() {return titulo;}
/**
 * Devuelve el director de la pelicula
 * @return Director de la pelicula
 */
  public String getDirector() {return director;}
/**
 * Devuelve el annio de la pelicula
 * @return Annio de la pelicula
 */
  public Integer getAnno() {return anno;}
/**
 * Devuelve la sinopsis de la pelicula
 * @return Sinopsis de la pelicula
 */
  public String getSinopsis() {return sinopsis;}
/**
 * Devuelve el genero de la pelicula
 * @return Genero de la pelicula
 */
  public Genero getGenero() {return genero;}
/**
 * Cambia el titulo de la pelicula
 * @param titulo Nuevo titulo de la pelicula
 */
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
/**
 * Cambia el directior de la pelicula
 * @param director Nuevo directir de la pelicula
 */
  public void setDirector(String director) {
    this.director = director;
  }
/**
 * Cambia el annio de la pelicula
 * @param anno Nuevo annio de la pelicula
 */
  public void setAnno(int anno) {
    this.anno = anno;
  }
/**
 * Cambia la sinopsis de la pelicula
 * @param sinopsis Nueva sinopsis de la pelicula
 */
  public void setSinopsis(String sinopsis) {
    this.sinopsis = sinopsis;
  }
/**
 * Cambia el genero de la pelicula
 * @param genero Nuevo genero de la pelicula
 */
  public void setGenero(Genero genero) {
    this.genero = genero;
  }
/**
 * Comprueba que dos peliculas son iguales
 * @param p Pelicula a comparar
 * @return true o false
 */
  public boolean equals(Pelicula p) {
	  if (this.titulo.equals(p.titulo) == false) {
		  return false;
	  }
	  if (this.director.equals(p.director) == false) {
		  return false;
	  }
	  if (this.sinopsis.equals(p.sinopsis) == false) {
		  return false;
	  }
	  if (this.anno != p.anno) {
		  return false;
	  }
	  if (this.genero != p.genero) {
		  return false;
	  }
	  return true;
  }
  /**
   * Devuelve un string con las caracteristicas de la pelicula
   */
  public String toString(){
    String s;
    s = "Pelicula: " + titulo + "\n";
    s = s + "Director: " + director + "\n";
    s = s + "Anno: " + anno + "\n";
    s = s + "Sinopsis: " + sinopsis + "\n";
    s = s + "Genero: " + genero.getNombre();
    return s;
  }
}
