package pkg0327.cagegui.v3.model;

public class Cage {
	private Strategy strategy;
	private static Cage single;		//保存创建的实例
 
	private Cage() {	//防止外部创建多的对象
		this.strategy = Strategy.RESERVED;
	}
	private Cage(Strategy strategy) {		
		this.strategy = strategy;
	}
	public static Cage create() {
		if(single == null) {
			single = new Cage();
		}		
		return single;
	}
	public static Cage create(String strategy) {//方法锁 防止多个线程同时访问
		synchronized (Cage.class){//块锁
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