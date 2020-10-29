package pkg0410.cagegui.model;

public class TakeCommand implements Command {
	private Cage cage;
	private Treasure t;
	private double quantity;
	public TakeCommand(Cage cage) {
		this.cage = cage;
	}

	@Override
	public void execute(Treasure t, double quantity) {
		this.t = t;
		this.quantity = quantity;
		cage.take(t, quantity);
	}

	@Override
	public void undo() {
		t.setNumber(t.getNumber()+quantity);
	}

}
