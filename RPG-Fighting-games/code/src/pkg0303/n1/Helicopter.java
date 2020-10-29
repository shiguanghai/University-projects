package pkg0303.n1;

public class Helicopter extends AircraftType {

	public Helicopter(){
		super(new VerticalTakeOff(),new SubSonicFly());
	}
	public void display() {
		System.out.println("I am Helicopter.");
	}

}
