package pkg0303.n1;

public abstract class AircraftType {

	protected TakeoffCharacteristics takeoffCharacteristics;
	protected FlightCharacteristics flightCharacteristics;
	public AircraftType(TakeoffCharacteristics takeoffCharacteristics,FlightCharacteristics flightCharacteristics){
		super();
		this.flightCharacteristics=flightCharacteristics;
		this.takeoffCharacteristics=takeoffCharacteristics;
	}

	public abstract void display();
	public void takeoff(){
		takeoffCharacteristics.takeoff();
	}
	public void flight(){
		flightCharacteristics.flight();
	}
}
