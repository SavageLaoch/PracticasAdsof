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
		nodo1 = (int) Math.floor(Math.random() * i1.totalNodos());
		nodo2 = (int) Math.floor(Math.random() * i2.totalNodos());
		System.out.print("Punto de cruce del progenitor 1: " + nodo1 + "\n");
		System.out.print("Punto de cruce del progenitor 2: " + nodo2 + "\n");
		if(nodo1 == 0 && nodo2 == 0) {
			throw new CruceNuloException();
		}
		
		
		ci1 = i1.getExpresion();
		ci2 = i2.getExpresion();
		
		descendiente1 = new Individuo();
		descendiente1.setExpresion(ci1.copy());
		descendiente1.setFitness(i1.getFitness());
		descendiente1.etiquetaNodos();
		
		
		descendiente2 = new Individuo();
		descendiente2.setExpresion(ci2.copy());
		descendiente2.setFitness(i2.getFitness());
		descendiente2.etiquetaNodos();
		
		n1 = descendiente1.getExpresion().getNodoEtiqueta(nodo1);
		n2 = descendiente2.getExpresion().getNodoEtiqueta(nodo2);

		copian1 = n1.copy();
		copian2 = n2.copy();
		
		descendiente1.getExpresion().intercambiarNodo(nodo1, copian2);
		descendiente2.getExpresion().intercambiarNodo(nodo2, copian1);
		
		descendiente1.etiquetaNodos();
		descendiente2.etiquetaNodos();
		
		descendientes.add(descendiente1);
		descendientes.add(descendiente2);
		return descendientes;
	}
}
