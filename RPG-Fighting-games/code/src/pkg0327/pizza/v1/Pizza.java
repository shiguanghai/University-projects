package pkg0327.pizza.v1;

public abstract class Pizza {
	public void prepare() {
		System.out.println("Pizza is preparing...");
	}
	public void bake() {
		System.out.println("Pizza is baking...");
	}
	public void cut() {
		System.out.println("Pizza is being cutted...");
	}
	public void box() {
		System.out.println("Pizza is being boxed...");
	}
}
