package pkg0410.devices;

public class TV {
 
	private TwoElectronicOutlet twoElectronicOutlet;
	 
	public void setTwoElectronicOutlet(TwoElectronicOutlet twoElectronicOutlet) {
		this.twoElectronicOutlet = twoElectronicOutlet;
	}

	public void turnOn() {
		if(this.twoElectronicOutlet != null) {
			System.out.println("电源已接通，电视机正常开机！");
		}
	}
	 
}
 
