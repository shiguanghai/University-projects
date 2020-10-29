package pkg0327.pizza.v2;

public class NYStylePizzaStore extends PizzaStore {

	@Override
	public Pizza createPizza(String type) {
		Pizza pizza = null;
		if(type.equals("cheese")) {
			pizza = new NYStyleCheesePizza();
		}else if(type.equals("veggie")) {
			pizza = new NYStyleVeggiePizza();
		}
		return pizza;
	}

}
