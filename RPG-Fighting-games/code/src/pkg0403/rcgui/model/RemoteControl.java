package pkg0403.rcgui.model;

public class RemoteControl {
	private Command[][] slot;

	public RemoteControl(int num) {
		slot = new Command[num][2];
	}
	
	public void setCommand(int i,int j,Command command) {
		slot[i][j] = command;
	}
	
	public void buttonPressed(int i,int j) {
		System.out.println("ң��������["+i+"]["+j+"]�����ˡ�");
		slot[i][j].execute();
	}

	public Command[][] getSlot() {
		return slot;
	}
	
}
