package pkg0415.m1;

public class SwitcherAdapter implements IStandardSwitchable {

	private Light light;

	public SwitcherAdapter(Light light) {
		this.light = light;
	}

	@Override
	public void connectElectricCurrent() {
		light.turnOff();
		light.turnOn();

	}
}
