package pkg0311.cage;

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