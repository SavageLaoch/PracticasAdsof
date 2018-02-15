import java.util.*;
/**
 * Esta aplicación calcula el número de combinaciones sin repetición de n elementos
 * tomados de k en k.
 * <p>La implementación es recursiva, basada en c(n, k) = c(n-1, k-1) + c(n-1, k)
 * Los casos base son c(n, 0) = 1 = c(n, n)  y c(n, k) = 0 para todo k mayor que n</p>
 * <p><b>Nota</b>: Esta implementación no es muy eficiente, al hacer muchos cálculos redundantes.
 * Se aconseja usar valores pequeños de n y k, entre 0 y 30</p>
 *
 * @author Juan Velasco y Miguel Angel Sanchez.
 *
 */
public class Combinatoria {

  private Map<Integer, Long> cache = new HashMap<>();
  public Combinatoria() {
  }

  private int posicion(int n, int k){
    return n*(n+1)/2 + k;
  }

  /**
   * Devuelve el número de combinaciones posibles de n elementos tomados de k en k.
   * En este caso, comprobaremos primero si están en cache. Si están, lo cargamos directamente.
   * Si no, calculamos el número y lo añadimos a la cache.
   * @param n Número de elementos totales
   * @param k Número de elementos, sin repetición, en cada combinación
   * @return valor del coeficiente binomial (n, k)
   */
  public long combinaciones(int n, int k){
    long l,s;
    //Primero comprobamos si los argumentos son válidos
    if (n<0 || k <0) throw new IllegalArgumentException("n y k han de ser positivos");
    //Casos base
    else if (k == 0 || n==k ) return 1; //caso base para 1
    else if (k > n) return 0; //caso base para 0
    //caso general
    else {
      //comprobamos si está en cache el número buscado
      if (cache.containsKey(posicion(n-1,k-1)) == false){
        //si no está, lo añadimos
        l = combinaciones(n-1,k-1);
        cache.put(posicion(n-1,k-1),l);
      }else{
        //si está, lo recogemos de la cache
        l = cache.get(posicion(n-1,k-1));
      }
      //repetimos lo mismo para el segundo valor
      if (cache.containsKey(posicion(n-1,k)) == false){
        s = combinaciones(n-1,k);
        cache.put(posicion(n-1,k),s);
      }else{
        s = cache.get(posicion(n-1,k));
      }

      return l + s;
    }
  }

}
