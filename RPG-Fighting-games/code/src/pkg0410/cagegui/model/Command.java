package pkg0410.cagegui.model;

public interface Command {
	public void execute(Treasure t, double quantity);
	public void undo();
}
