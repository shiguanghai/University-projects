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
		System.out.println("�ƿ��ˣ�");
		this.on = true;
	}	
	public void turnOff() {
		System.out.println("�ƹ��ˣ�");
		this.on = false;
	}

}
