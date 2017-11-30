package buis.dan.SpringIndustry;

/**
 * A collection of a basic or intermediate resource gathered by the player.  Knows how much stuff is in the stack,
 * and how valuable it is.  Manages quantity and value as the player adds and consumes the resource.
 * @author dbuis
 *
 */

public class ResourceStack {

	private String type = "";
	private int quantity;
	private double value;
	
	//default constructor
	public ResourceStack() {
		
	}
	
	//Parameterized constructor
	public ResourceStack(String type, int quantity, double value) {
		this.type = type;
		this.quantity = quantity;
		this.value = value;
	}
	
	/**
	 * divides this stack in 2, returning the portion to be used.
	 * @return
	 */
	
	public ResourceStack split(int quantity) {
		//not enough to do the split
		if (quantity>this.quantity) {
			return null;
		}
		
		double currentPerItemValue = perItemValue();
		
		//create new stack
		ResourceStack returnStack = new ResourceStack(this.type, quantity, quantity*currentPerItemValue);
		
		//update this stack
		this.quantity-=quantity;
		this.value = this.quantity*currentPerItemValue;
		
		return returnStack;
	}
	
	/**
	 * adds a quantity to stack, assumes the current per item value.  Most often used when processing ore in a facility
	 * that does not charge a fee.  Note that resources NEVER have a value of 0!
	 * @param quantity
	 */
	public void addToStack(int quantity) {
		double currentPerItemValue = perItemValue();
		
		this.quantity+=quantity;
		this.value = this.quantity*currentPerItemValue;
	}
	
	/**
	 * adds a quantity to the stack with a given value.  Use this when the per item value is unknown or
	 * different from the current per item value. Note that resources NEVER have a value of 0!
	 * @param quantity
	 * @param value
	 */
	public void addToStack(int quantity, double value) {
		this.quantity+=quantity;
		this.value +=value;
		
	}

	/**
	 * calculates the value of a single item in the stack
	 * @return
	 */
	private double perItemValue() {
		
		return this.quantity/this.value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	
	
}
