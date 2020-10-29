package pkg0320.cagegui.v2.model;

public class Cage {
	private Strategy strategy;
 
	public Cage() {		
		this.strategy = Strategy.RESERVED;
	}
	public Cage(Strategy strategy) {		
		this.strategy = strategy;
	}
	public void take(Treasure t, double quantity) {//����quantity�����ߵ�����
		strategy.take(t, quantity);		
	}
	public Strategy getStrategy() {
		return strategy;
	}
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}	 
}