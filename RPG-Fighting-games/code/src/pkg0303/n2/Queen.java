package pkg0303.n2;

public class Queen extends Character {
	public Queen(){
		super(new KnifeBehavior());
	}

	public void fight() {
		System.out.println("Queen fight you.");
	}
}
