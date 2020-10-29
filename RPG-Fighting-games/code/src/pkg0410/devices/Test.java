package pkg0410.devices;

public class Test {

	public static void main(String[] args) {
		TV tv  = new TV();
		WashingMachine wm = new WashingMachine();		
		ThreeElectronicOutlet three = new ThreeElectronicOutlet();
		
		wm.setThreeElectronicOutlet(three);
		wm.turnOn();
		
		tv.setTwoElectronicOutlet(new Adapter(three));
		tv.turnOn();
		

	}

}
