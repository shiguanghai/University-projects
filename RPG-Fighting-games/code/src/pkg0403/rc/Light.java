package pkg0403.rc;

public class Light {
	private boolean on;

	public Light() {
		on = false;
	}
	public boolean isOn() {
		return on;
	}
	public void turnOn() {
		System.out.println("灯开了！");
		this.on = true;
	}	
	public void turnOff() {
		System.out.println("灯关了！");
		this.on = false;
	}

}
