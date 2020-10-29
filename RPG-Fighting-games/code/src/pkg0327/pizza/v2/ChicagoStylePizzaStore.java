package pkg0327.pizza.v2;

public class ChicagoStylePizzaStore extends PizzaStore {

	@Override
	public Pizza createPizza(String type) {
		Pizza pizza = null;
		if(type.equals("cheese")) {
			pizza = new ChicagoStyleCheesePizza();
		}else if(type.equals("veggie")) {
			pizza = new ChicagoStyleVeggiePizza();
		}
		return pizza;
	}

}
