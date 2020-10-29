package pkg0403.rcgui.model;

public class LightOnCommand implements Command {
	private Light light;

	public LightOnCommand(Light light) {		
		this.light = light;
	}

	@Override
	public void execute() {
		System.out.println("��������ִ���ˣ�");
		light.turnOn();
	}
}
