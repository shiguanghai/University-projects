package pkg0410.devices;

public class WashingMachine {
 
	private ThreeElectronicOutlet threeElectronicOutlet;
	
	public void setThreeElectronicOutlet(ThreeElectronicOutlet threeElectronicOutlet) {
		this.threeElectronicOutlet = threeElectronicOutlet;
	}

	public void turnOn() {
		if(this.threeElectronicOutlet != null) {
			System.out.println("已接通电源，洗衣机正常开机！");
		}
	}
	 
}
 
