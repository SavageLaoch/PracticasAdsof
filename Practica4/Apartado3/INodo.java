import java.util.*;

public interface INodo {
	
	
	public String getRaiz();
	public List<INodo> getDescendientes();
	public void incluirDescendiente(INodo nodo);
	public double calcular();
	public double calcular(double x);
	public INodo copy();
}

