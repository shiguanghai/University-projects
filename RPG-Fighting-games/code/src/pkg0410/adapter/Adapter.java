package pkg0410.adapter;

public class Adapter extends Duck{
	private Turkey turkey;

	public Adapter(Turkey turkey) {
		super();
		this.turkey = turkey;
	}
	
	public void play() {
		turkey.play();
	}
}
