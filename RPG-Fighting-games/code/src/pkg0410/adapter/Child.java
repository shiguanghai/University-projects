package pkg0410.adapter;

public class Child {
	private Duck duck;
	
	public Duck getDuck() {
		return duck;
	}

	public void setDuck(Duck duck) {
		this.duck = duck;
	}

	public void play() {
		duck.play();
	}
}
