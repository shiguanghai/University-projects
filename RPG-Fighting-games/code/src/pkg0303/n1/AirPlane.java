package pkg0303.n1;

public class AirPlane extends AircraftType {

	public AirPlane(){
		super(new LongDistanceTakeOff(),new SubSonicFly());
	}
	public void display() {
		System.out.println("I am AirPlane.");
	}

}
