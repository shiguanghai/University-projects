package pkg0313.drink;

public class Test {

	public static void main(String[] args) {
		Beverage b = new SteamedMilk(new Mocha(new Espresso()));
		System.out.println(b.getDescription());
		System.out.println("$"+b.cost());

	}

}
