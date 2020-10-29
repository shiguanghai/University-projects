package pkg0327.pizza.v2;

public abstract class PizzaStore {
	
	public abstract Pizza createPizza(String type);
	
	public Pizza orderPizza(String type) {
		Pizza pizza;
		
		pizza = createPizza(type);
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
