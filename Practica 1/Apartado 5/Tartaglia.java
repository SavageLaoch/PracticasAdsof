/**
* Esta aplicacion imprime por pantalla el triangulo de tartaglia de la
* altura n introducida como argumento utilizando el fichero dado de
* combinatoria.
* @author Juan Velasco y Miguel Angel Sanchez.
**/
import java.util.*;

public class Tartaglia {

  private Combinatoria c;
  private int n;
  private Map<Integer, Long> cache = new HashMap<>();

  /** 
  * Construye un nuevo objeto de tipo Tartaglia con los parametros.
  * @param c Objeto combinatoria
  * @param n Numero de filas.
  **/
  public Tartaglia (Combinatoria c, int n){
    this.c = c;
    this.n = n;
  }

  private int posicion(int n, int k){ 
    return n*(n+1)/2 + k;
  }

  /** 
  * Convierte a texto el triangulo de Tartaglia.
  * @return Cadena de caracteres con el triangulo.
  **/
  public String toString(){
    Long l;
    String s="";
    int i,j;
    for (i=0; i<n; i++){
      for (j=0; j<=i;j++){
        if (cache.containsKey(posicion(i,j))==false) {
          l = c.combinaciones(i,j);
          s = s + " " + l;
          cache.put(posicion(i,j),l);
        }
        else{
          s = s + " " + cache.get(posicion(i,j));
        }
      }
      s = s + "\n";
    }
    return s;
  }
  /** 
  * Punto de entrada a la aplicacion.
  * Este metodo imprime el triangulo de tartaglia asociado al
  * parametro de entrada
  * @param args Argumento de la linea de comandos. Se espera un numero
  * entero, como cadena.
  **/
  public static void main(String[] args){

    if (args.length!=1){
      System.out.println("Se espera un numero como parametro, n");
      System.out.println("n = Altura del triangulo");
      System.out.println("Imprime el triangulo de Tartaglia de altura n");
    }

    else {
      Combinatoria c = new Combinatoria();
      int n = Integer.parseInt(args[0]);
      System.out.println(new Tartaglia(c,n));
    }
  }


}
