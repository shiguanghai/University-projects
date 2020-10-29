package pkg0410.cagegui.model;

import java.util.Stack;

public class CageMemDecorator extends Cage{
	private Cage cage;
	private Stack<Command> mem;
	public CageMemDecorator(Cage cage) {
		this.cage = cage;
		mem = new Stack<Command>();
	}
	public void take(Treasure t,double quantity) {
		Command command = new TakeCommand(cage);
		mem.push(command);
		command.execute(t, quantity);
	}
	public void undo() {
		if(!mem.empty()) {
			Command command = mem.pop();
			command.undo();
		}else {
			System.out.println("Cage have nothing to do.");
		}
	}
	

}
