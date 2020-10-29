package pkg0327.pizza.v2;

public class Test {

	public static void main(String[] args) {
		PizzaStore store = new ChicagoStylePizzaStore();
		
		store.orderPizza("cheese");
		store.orderPizza("veggie");

	}

}
