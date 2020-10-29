package pkg0327.pizza.v1;

public class Test {

	public static void main(String[] args) {
		PizzaStore store = new PizzaStore(new SimplePizzaFactory());
		
		store.orderPizza("cheese");		
		store.orderPizza("veggie");
	}
}
