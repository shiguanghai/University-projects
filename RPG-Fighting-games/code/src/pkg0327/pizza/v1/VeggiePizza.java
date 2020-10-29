package pkg0327.pizza.v1;

public class VeggiePizza extends Pizza{
	public void prepare() {
		System.out.print("Veggie ");
		super.prepare();
	}
	public void bake() {
		System.out.print("Veggie ");
		super.bake();
	}
	public void cut() {
		System.out.print("Veggie ");
		super.cut();
	}
	public void box() {
		System.out.print("Veggie ");
		super.box();
	}
}
