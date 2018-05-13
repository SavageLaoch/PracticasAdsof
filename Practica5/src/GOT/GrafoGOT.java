package GOT;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import grafo.GrafoNoDirigido;
import vertice.Vertice;

public class GrafoGOT extends GrafoNoDirigido<PersonajeGOT> {
	/**
	 * Crea el grafo GOT a partir de los ficheros dados
	 * 
	 * @param ficheroVertices
	 *            Nombre del fichero de los vertices
	 * @param ficheroArcos
	 *            Nombre del fichero de los arcos
	 * @throws Exception
	 *             Excepciones lanzadas por los metodos
	 */
	public GrafoGOT(String ficheroVertices, String ficheroArcos) throws Exception {
		super();
		FileInputStream f = null;
		String line;
		f = new FileInputStream(ficheroVertices);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(f));
		while ((line = buffer.readLine()) != null) {
			String[] cosas = line.split(",");
			PersonajeGOT personaje = new PersonajeGOT(cosas[1], cosas[2]);
			super.addVertice(Integer.parseInt(cosas[0]), personaje);
		}
		buffer.close();
		f = new FileInputStream(ficheroArcos);
		BufferedReader buffer1 = new BufferedReader(new InputStreamReader(f));
		while ((line = buffer1.readLine()) != null) {
			String[] cosas = line.split(",");
			super.addArco(super.getVertice(Integer.parseInt(cosas[0])), super.getVertice(Integer.parseInt(cosas[1])),
					Double.parseDouble(cosas[2]));
		}
		buffer1.close();

	}

	/**
	 * Devuelve el vertice a partir de un nombre dado
	 * 
	 * @param nombre
	 *            Nombre del personaje
	 * @return Vertice del personaje
	 */
	public Vertice<PersonajeGOT> getVertice(String nombre) {
		return this.getVertices().stream().filter(v -> v.getDatos().getNombre().equals(nombre)).findFirst().get();
	}

	/**
	 * Devuelve una lista con los distintos nombres de la casa
	 * 
	 * @return Lista con los Strings de las casas
	 */
	public List<String> casas() {
		Set<String> set = this.getVertices().stream().map(Vertice<PersonajeGOT>::getDatos).map(PersonajeGOT::getCasa)
				.collect(Collectors.toCollection(() -> new TreeSet<String>()));
		return new ArrayList<String>(set);
	}

	/**
	 * Devuelve los miembros de una casa concreta
	 * 
	 * @param casa
	 *            Nombre de la casa
	 * @return Lista con los nombres de los personajes
	 */
	public List<String> miembrosCasa(String casa) {
		Predicate<PersonajeGOT> predicado = new Predicate<PersonajeGOT>() {
			@Override
			public boolean test(PersonajeGOT personaje) {
				return casa.equals(personaje.getCasa());
			}
		};

		List<String> personajes = new ArrayList<>();

		for (Vertice<PersonajeGOT> personaje : this.vertices.values()) {
			if (predicado.test(personaje.getDatos())) {
				personajes.add(personaje.getDatos().getNombre());
			}
		}

		return personajes;

	}

	/**
	 * Devuelve un mapa con los personajes y sus grados (suma de sus vecinos)
	 * 
	 * @return Map de string-integer
	 */
	public Map<String, Integer> gradoPersonajes() {
		Map<String, Integer> hash = new HashMap<>();
		this.getVertices().stream().forEach((p) -> {
			hash.put(p.getDatos().getNombre(), this.getVecinosDe(p).size());
		});
		return hash;
	}

	/**
	 * Devuelve un mapa con los personajes y sus grados ponderados (suma de los
	 * grados de sus arcos)
	 * 
	 * @return Map de string-integer
	 */
	public Map<String, Double> gradoPonderadoPersonajes() {
		Map<String, Double> hash = new HashMap<>();
		this.getVertices().stream().forEach((p) -> {
			double res = 0;
			for (Vertice<PersonajeGOT> v : this.getVecinosDe(p)) {
				res = res + this.getPesoDe(v, p);
			}
			hash.put(p.getDatos().getNombre(), res);
		});
		return hash;
	}

	/**
	 * Devuelve un mapa con los personajes mas relevantes del grafo
	 * 
	 * @return Map de string-integer
	 */
	public Map<String, Double> personajesRelevantes() {
		Map<String, Double> gradoPonderado = this.gradoPonderadoPersonajes();
		Map<String, Double> ret = new HashMap<>();
		double media = gradoPonderado.values().stream().reduce((x, y) -> x + y).get() / gradoPonderado.keySet().size();

		gradoPonderado.keySet().stream().forEach((p) -> {
			if (gradoPonderado.get(p) > media) {
				ret.put(p, gradoPonderado.get(p));
			}
		});
		return ret;
	}

}