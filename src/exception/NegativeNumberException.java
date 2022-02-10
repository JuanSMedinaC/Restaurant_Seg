package exception;

public class NegativeNumberException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double value;
	
	public NegativeNumberException(double value) {
		super("It's not possible to use "+value+" because is a negative number");
		this.setValue(value);
		
		
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
