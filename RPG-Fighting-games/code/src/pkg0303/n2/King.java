package pkg0303.n2;

public class King extends Character {
	public King(){
		super(new SwordBehavior());
	}

	public void fight() {
		System.out.println("King fight you.");
	}

}
