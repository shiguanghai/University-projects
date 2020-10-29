package pkg0320.cagegui.v2.model;

public class ReservedStrategy implements Strategy {

	@Override
	public void take(Treasure t, double quantity) {
		if(t.getNumber() >= quantity) {
			t.setNumber(t.getNumber()-quantity);
		}
	}
}
