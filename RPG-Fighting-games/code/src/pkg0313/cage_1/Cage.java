package pkg0313.cage_1;

public class Cage {
 
	public void take(Treasure t, double quantity) {//假设quantity是拿走的量。
		if(t.getNumber() >= quantity) {
			t.setNumber(t.getNumber()-quantity);
		}//如果量不够拿的，Cage就不拿了。
		else{
			t.setNumber(0);
		}
	}	 
}