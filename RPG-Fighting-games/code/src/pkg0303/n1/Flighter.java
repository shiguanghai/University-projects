package pkg0303.n1;

public class Flighter extends AircraftType {

	public Flighter(){
		super(new LongDistanceTakeOff(),new SuperSonicFly());
	}
	public void display() {
		System.out.println("I am Flighter.");
	}

}
