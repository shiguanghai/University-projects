package pkg0403.rcgui.model;

public class LightOffCommand implements Command {
	private Light light;

	public LightOffCommand(Light light) {		
		this.light = light;
	}

	@Override
	public void execute() {
		System.out.println("�ص�����ִ���ˣ�");
		light.turnOff();
	}

}
