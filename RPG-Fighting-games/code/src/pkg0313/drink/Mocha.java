package pkg0313.drink;

public class Mocha extends Condiment {
 
	public Mocha(Beverage beverage) {
		super(beverage);
	}

	public String getDescription() {
		return beverage.getDescription()+" with Mocha";
	}
	 
	public double cost() {
		return beverage.cost() + 0.2;
	}
	 
}
 
