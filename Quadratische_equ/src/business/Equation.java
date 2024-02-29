package business;

public class Equation {
	private double argA;
	private double argB;
	private double argC;
	
	public Equation(double argA,double argB,double argC) {
		this.argA=argA;
		this.argB=argB;
		this.argC=argC;
	}
	public Equation() {
		
	}
	public double getArgA() {
		return argA;
	}
	public void setArgA(double argA) {
		this.argA = argA;
	}
	public double getArgB() {
		return argB;
	}
	public void setArgB(double argB) {
		this.argB = argB;
	}
	public double getArgC() {
		return argC;
	}
	public void setArgC(double argC) {
		this.argC = argC;
	}
	
	
}
