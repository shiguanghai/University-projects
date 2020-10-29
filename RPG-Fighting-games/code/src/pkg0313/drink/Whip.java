package pkg0313.drink;

public class Whip extends Condiment {
 
	public Whip(Beverage beverage) {
		super(beverage);
	}

	public String getDescription() {
		return beverage.getDescription() + " with Whip";
	}
	 
	public double cost() {
		return beverage.cost() + 0.1;
	}
	 
}
 
