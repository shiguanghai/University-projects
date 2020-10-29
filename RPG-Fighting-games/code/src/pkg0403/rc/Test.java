package pkg0403.rc;

public class Test {

	public static void main(String[] args) {
		RemoteControl rc = new RemoteControl(4);
		Light[] lights = new Light[4];
		for(int i=0;i<lights.length;i++) {
			lights[i] = new Light();
			rc.setCommand(i, 0, new LightOnCommand(lights[i]));
			rc.setCommand(i, 1, new LightOffCommand(lights[i]));
		}
		
		rc.buttonPressed(0, 1);
		rc.buttonPressed(0, 0);
		
		rc.buttonPressed(2, 1);
		rc.buttonPressed(2, 0);

	}

}
