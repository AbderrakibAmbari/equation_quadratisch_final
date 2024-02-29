package business;



public class Model {
	private Equation equa;
	public Model() {
	}
	public void addNummer(Double argA,Double argB,Double argC) {
			setEqua(new Equation(argA,argB,argC));
		
	}
	public Equation getEqua() {
		return equa;
	}
	public void setEqua(Equation equa) {
		this.equa = equa;
	}

}
