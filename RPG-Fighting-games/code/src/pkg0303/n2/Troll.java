package pkg0303.n2;

public class Troll extends Character {
	public Troll(){
		super(new AxeBehavior());
	}

	public void fight() {
		System.out.println("Troll fight you.");
	}
}