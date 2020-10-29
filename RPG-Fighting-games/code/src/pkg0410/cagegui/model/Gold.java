package pkg0410.cagegui.model;

public class Gold extends Treasure {
	public Gold(int id,double quantity) {
		super(id,quantity);
	}
	public Gold() {
		super();
	}
	@Override
	public String toString() {
		return "Gold [id=" + id + ", number=" + number + "]";
	}
	
}