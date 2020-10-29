package pkg0407.n1;

public class ArmySupervisor {

	Command command;

	public void setCommand(Command command) {
		this.command=command;
	}

	public void starExecuteCommand() {
		command.execute();
	}

}
