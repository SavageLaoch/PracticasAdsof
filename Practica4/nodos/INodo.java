package nodos;
import java.util.*;

public interface INodo {
	
	
	public String getRaiz();
	public List<INodo> getDescendientes();
	public void incluirDescendiente(INodo nodo);
	public double calcular();
	public double calcular(double x);
	public INodo copy();
	public int etiquetar(int etiqueta);
	public int getEtiqueta();
	public INodo getNodoEtiqueta(int etiqueta);
}

