package pkg0303.n1;

public class Harrier extends AircraftType {

	public Harrier(){
		super(new VerticalTakeOff(),new SuperSonicFly());
	}
	public void display() {
		System.out.println("I am Harrier.");
	}


}
