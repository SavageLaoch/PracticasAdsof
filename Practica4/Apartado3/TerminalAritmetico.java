
public class TerminalAritmetico extends Terminal{

	public TerminalAritmetico(String raiz) {
		super(raiz);
	}
	
	public INodo copy() {
		Terminal t = new TerminalAritmetico(this.getRaiz());
		return t;
	}

}
