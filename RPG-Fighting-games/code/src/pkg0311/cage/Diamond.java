package pkg0311.cage;

public class Diamond extends Treasure {
	public Diamond(int id, double quantity) {
		super(id,quantity);
	}
	
	public Diamond() {
		super();
	}

	@Override
	public String toString() {
		return "Diamond [id=" + id + ", number=" + number + "]";
	}
}
 
