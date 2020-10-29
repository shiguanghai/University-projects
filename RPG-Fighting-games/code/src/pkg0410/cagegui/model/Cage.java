package pkg0410.cagegui.model;

public class Cage {
	private Strategy strategy;
	private static Cage single;
 
	protected Cage() {		
		this.strategy = Strategy.RESERVED;
	}
	protected Cage(Strategy strategy) {		
		this.strategy = strategy;
	}
	public static Cage create() {
		if(single == null) {
			single = new Cage();
		}		
		return single;
	}
	public static Cage create(String strategy) {
		synchronized(Cage.class) {
			if(single == null) {	
				single = new Cage();
			}
		}
		if(strategy.equals("greedy")) {
			single.setStrategy(Strategy.GREEDY);
		}else if(strategy.equals("reserved")){
			single.setStrategy(Strategy.RESERVED);
		}
		return single;
	}
	public void take(Treasure t, double quantity) {//假设quantity是拿走的量。
		strategy.take(t, quantity);		
	}
	public Strategy getStrategy() {
		return strategy;
	}
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}	 
}