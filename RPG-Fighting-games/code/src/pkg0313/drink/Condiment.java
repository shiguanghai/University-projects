package pkg0313.drink;

public abstract class Condiment extends Beverage {
 
	protected Beverage beverage;
	 
	public Condiment(Beverage beverage) {
		this.beverage = beverage;
	}

	public abstract String getDescription();
	 
}
 
