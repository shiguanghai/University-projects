package pkg0313.drink;

public class SteamedMilk extends Condiment {
 
	public SteamedMilk(Beverage beverage) {
		super(beverage);
	}

	public String getDescription() {
		return beverage.getDescription()+" with Steamed milk";
	}
	 
	public double cost() {
		return beverage.cost() + 0.1;
	}
	 
}
 
