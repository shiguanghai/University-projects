package pkg0320.cagegui.v2.model;

public interface Strategy {
	public static final Strategy GREEDY = new GreedyStrategy();
	public static final Strategy RESERVED = new ReservedStrategy();
	
	public void take(Treasure t, double quantity);
}
