package pkg0318.Icecream_1;

public class HoneyDecorator extends IcecreamDecorator {

	public HoneyDecorator(Icecream icecream){
		super(icecream);
	}

	public HoneyDecorator(){

	}

	public String addHoney() {
		return " add Honey.";
	}

	public String makeIcecream() {
		return icecream.makeIcecream() + this.addHoney();
	}

}
