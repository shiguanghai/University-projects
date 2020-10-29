package pkg0303.n2;

public class Knight extends Character {
	public Knight(){
		super(new BowAndArrowBehavior());
	}

	public void fight() {
		System.out.println("Knight fight you.");
	}
}