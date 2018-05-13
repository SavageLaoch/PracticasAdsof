package GOT;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import grafo.GrafoNoDirigido;
import vertice.Vertice;

public class GrafoGOT extends GrafoNoDirigido<PersonajeGOT>{
	public GrafoGOT(String ficheroVertices, String ficheroArcos) throws Exception {
		super();
		FileInputStream f = null;
		String line;
		f = new FileInputStream(ficheroVertices);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(f));
		while ((line = buffer.readLine()) != null) {
			String[] cosas = line.split(",");
			PersonajeGOT personaje = new PersonajeGOT(cosas[1], cosas[2]);
			super.addVertice(Integer.parseInt(cosas[0]),personaje);
		}
		buffer.close();
		f = new FileInputStream(ficheroArcos);
		BufferedReader buffer1 = new BufferedReader(new InputStreamReader(f));
		while ((line = buffer1.readLine()) != null) {
			String[] cosas = line.split(",");
			super.addArco(super.getVertice(Integer.parseInt(cosas[0])),super.getVertice(Integer.parseInt(cosas[1])), Double.parseDouble(cosas[2]));
		}
		buffer1.close();
		
	}
	
	public Vertice<PersonajeGOT> getVertice(String nombre){
		return this.getVertices().stream().filter(v -> v.getDatos().getNombre().equals(nombre)).findFirst().get();
	}
	
	public List<String> casas(){
		Set<String> set = this.getVertices().stream().map(Vertice<PersonajeGOT>::getDatos).map(PersonajeGOT::getCasa).collect(Collectors.toCollection(()->new TreeSet<String>()));
		return new ArrayList<String>(set);
	}
		
	public List<String> miembrosCasa(String casa){
		Predicate<PersonajeGOT> predicado = new Predicate<PersonajeGOT>() {
			@Override
			public boolean test(PersonajeGOT personaje) {
				return casa.equals(personaje.getCasa());
			}
		};
		
		List<String> personajes = new ArrayList<>();
		
		for(Vertice<PersonajeGOT> personaje: this.vertices.values()) {
			if(predicado.test(personaje.getDatos())) {
				personajes.add(personaje.getDatos().getNombre());
			}
		}
		
		return personajes;
		
	}
		
	public Map<String, Integer> gradoPersonajes(){
		Map<String,Integer> hash = new HashMap<>();
		this.getVertices().stream().forEach((p) ->{
			hash.put(p.getDatos().getNombre(),this.getVecinosDe(p).size());
		});
		return hash;
	}
			
	public Map<String, Double> gradoPonderadoPersonajes(){
		Map<String,Double> hash = new HashMap<>();
		this.getVertices().stream().forEach((p) ->{
			double res = 0;
			for(Vertice<PersonajeGOT> v: this.getVecinosDe(p)) {
				res = res + this.getPesoDe(v, p);
			}
			hash.put(p.getDatos().getNombre(),res);
		});
		return hash;
	}
				
	public Map<String, Double> personajesRelevantes(){
		Map<String,Double> gradoPonderado = this.gradoPonderadoPersonajes();
		Map<String,Double> ret = new HashMap<>();
		double media = gradoPonderado.values().stream().reduce((x,y) -> x+y).get() / gradoPonderado.values().size() ;
		
		gradoPonderado.keySet().stream().forEach((p)->{
			if (gradoPonderado.get(p) > media) {
				ret.put(p, gradoPonderado.get(p));
			}
		});
		return ret;
	}
	
}