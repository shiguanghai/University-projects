package pkg0327.pizza.v1;

public class CheesePizza extends Pizza {
	public void prepare() {
		System.out.print("Cheese ");
		super.prepare();
	}
	public void bake() {
		System.out.print("Cheese ");
		super.bake();
	}
	public void cut() {
		System.out.print("Cheese ");
		super.cut();
	}
	public void box() {
		System.out.print("Cheese ");
		super.box();
	}
}
