package pkg0403.rcgui.model;

public class Room {
	private int num;//µÆµÄÊýÁ¿
	private RemoteControl rc;
	private Light[] lights;
	
	public Room(int num) {
		this.num = num;
		rc = new RemoteControl(num);
		lights = new Light[num];
		for(int i=0;i<lights.length;i++) {
			lights[i] = new Light();
			rc.setCommand(i, 0, new LightOnCommand(lights[i]));
			rc.setCommand(i, 1, new LightOffCommand(lights[i]));
		}
	}
	public RemoteControl getRc() {
		return rc;
	}
	public Light[] getLights() {
		return lights;
	}
	public int getNum() {
		return num;
	}
	
}
