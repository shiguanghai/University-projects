package pkg0320.cagegui.v2.model;
import java.util.ArrayList;

public abstract class Treasure { 
	protected int id;	 
	protected double number;
	private ArrayList<Eudemon> eudemons = new ArrayList<Eudemon>();
	
	public Treasure() {	
		this.id = 0;
		this.number = 100;
	}	 
	public Treasure(int id, double number) {
		this.id = id;
		this.number = number;
	}

	public void guard(Eudemon e) {
		eudemons.add(e);
	}	 
	public void remove(Eudemon e) {
		eudemons.remove(e);
	}	 
	public void notifyEudemon() {
		for(Eudemon e:eudemons) {
			e.update(number);
		}
	}
	public double getNumber() {
		return number;
	}
	public void setNumber(double number) {
		this.number = number;
		notifyEudemon();
	}
	public int getId() {
		return id;
	}	 
}