package pkg0410.cagegui.model;

public interface Strategy {
	public static final Strategy GREEDY = new GreedyStrategy();
	public static final Strategy RESERVED = new ReservedStrategy();
	
	public void take(Treasure t, double quantity);
}
