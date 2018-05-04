package GOT;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import grafo.GrafoNoDirigido;
import vertice.Vertice;

public class GrafoGOT extends GrafoNoDirigido<PersonajeGOT>{
	public GrafoGOT(String ficheroVertices, String ficheroArcos) throws Exception {
		super();
		FileInputStream f = null;
		String line;
		f = new FileInputStream("got-s1-vertices.csv");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(f));
		while ((line = buffer.readLine()) != null) {
			String[] cosas = line.split(",");
			PersonajeGOT personaje = new PersonajeGOT(cosas[1], cosas[2]);
			super.addVertice(Integer.parseInt(cosas[0]),personaje);
		}
		buffer.close();
		
		f = new FileInputStream("got-s01-vertices.csv");
		buffer = new BufferedReader(new InputStreamReader(f));
		while ((line = buffer.readLine()) != null) {
			String[] cosas = line.split(",");
			super.addArco(this.getVertice(Integer.parseInt(cosas[0])),this.getVertice(Integer.parseInt(cosas[1])), Integer.parseInt(cosas[2]));
		}
		buffer.close();
		
	}
	
	public Vertice<PersonajeGOT> getVertice(String nombre){
		
	}
	
	public List<String> casas(){
		
	}
		
	public List<String> miembrosCasa(String casa){
		
	}
		
	public Map<String, Integer> gradoPersonajes(){
		
	}
			
	public Map<String, Integer> gradoPonderadoPersonajes(){
		
	}
				
	public Map<String, Integer> personajesRelevantes(){
		
	}
	
}