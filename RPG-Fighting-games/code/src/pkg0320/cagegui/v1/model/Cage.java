package pkg0320.cagegui.v1.model;

public class Cage {
 
	public void take(Treasure t, double quantity) {//假设quantity是拿走的量。
		if(t.getNumber() >= quantity) {
			t.setNumber(t.getNumber()-quantity);
		}else{//如果量不够拿的，Cage不嫌乎，有多少拿多少。
			t.setNumber(0);
		}
		
	}	 
}