package pkg0403.rc;

public class LightOnCommand implements Command {
	private Light light;

	public LightOnCommand(Light light) {		
		this.light = light;
	}

	@Override
	public void execute() {
		System.out.println("¿ªµÆÃüÁîÖ´ĞĞÁË£¡");
		light.turnOn();
	}
}
