import java.util.List;

public class Individuo implements IIndividuo {
	
	private INodo expresion;
	private double fitness;
	@Override
	public INodo getExpresion() {
		return expresion;
	}

	@Override
	public void setExpresion(INodo expresion) {
		this.expresion = expresion;

	}

	@Override
	public double getFitness() {
		return fitness;
	}

	@Override
	public void setFitness(double fitness) {
		this.fitness = fitness;

	}

	@Override
	public void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones) {
		// TODO Auto-generated method stub

	}

	@Override
	public double calcularExpresion() {
		return expresion.calcular();
	}
	
	public double calcularExpresion(double x) {
		return expresion.calcular(x);
	}

	@Override
	public int getNumeroNodos() {
		return 0;
	}

	@Override
	public void writeIndividuo() {
		System.out.println("Expresion: " + expresion.toString());
	}

}
