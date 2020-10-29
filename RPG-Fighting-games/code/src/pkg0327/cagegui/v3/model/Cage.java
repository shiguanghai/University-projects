package pkg0327.cagegui.v3.model;

public class Cage {
	private Strategy strategy;
	private static Cage single;		//���洴����ʵ��
 
	private Cage() {	//��ֹ�ⲿ������Ķ���
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
	public static Cage create(String strategy) {//������ ��ֹ����߳�ͬʱ����
		synchronized (Cage.class){//����
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