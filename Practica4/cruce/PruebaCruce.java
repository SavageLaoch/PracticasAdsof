package cruce;
import java.util.*;

import exceptions.CruceNuloException;
import individuo.IIndividuo;
import individuo.Individuo;
import nodos.INodo;

public class PruebaCruce {
	
	public List<IIndividuo> cruce(IIndividuo i1,IIndividuo i2) throws CruceNuloException{
		int nodo1,nodo2;
		INodo n1,n2;
		INodo copian1,copian2,ci1,ci2;
		IIndividuo descendiente1,descendiente2;
		List<IIndividuo> descendientes = new ArrayList<>();
		nodo1 = (int) Math.floor(Math.random() * 10);
		nodo2 = (int) Math.floor(Math.random() * 10);
		System.out.print("Punto de cruce del progenitor 1: " + nodo1 + "\n");
		System.out.print("Punto de cruce del progenitor 2: " + nodo2 + "\n");
		n1 = i1.getExpresion().getNodoEtiqueta(nodo1);
		n2 = i2.getExpresion().getNodoEtiqueta(nodo2);
		if(n1 == i1.getExpresion() && n2 == i2.getExpresion()) {
			throw new CruceNuloException();
		}
		copian1 = n1.copy();
		copian2 = n2.copy();
		ci1 = i1.getExpresion();
		ci2 = i2.getExpresion();
		n1 = ci1.getNodoEtiqueta(nodo1);
		n2 = ci2.getNodoEtiqueta(nodo2);
		n1 = copian2;
		n2 = copian1;
	
		descendiente1 = new Individuo();
		descendiente1.setExpresion(ci1);
		
		descendiente2 = new Individuo();
		descendiente2.setExpresion(ci2);
		descendientes.add(descendiente1);
		descendientes.add(descendiente2);
		
		return descendientes;
	}
}
