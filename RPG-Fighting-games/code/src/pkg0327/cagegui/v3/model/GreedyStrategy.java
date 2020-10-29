package pkg0327.cagegui.v3.model;

public class GreedyStrategy implements Strategy {

	@Override
	public void take(Treasure t, double quantity) {
		if(t.getNumber() >= quantity) {
			t.setNumber(t.getNumber()-quantity);
		}else{//如果量不够拿的，Cage不嫌乎，有多少拿多少。
			t.setNumber(0);
		}
	}
}
