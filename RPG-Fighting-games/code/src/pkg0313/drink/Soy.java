package pkg0313.drink;

public class Soy extends Condiment {
 
	public Soy(Beverage beverage) {
		super(beverage);
	}

	public String getDescription() {
		return beverage.getDescription() + " with Soy";
	}
	 
	public double cost() {
		return beverage.cost() + 0.15;
	}
	 
}
 
