package pkg0318.Icecream_1;

public class NuttyDecorator extends IcecreamDecorator {

	public NuttyDecorator(Icecream icecream){
		super(icecream);
	}

	public String addNuts() {
		return " add Nuts";
	}

	public String makeIcecream() {
		return icecream.makeIcecream() + this.addNuts();
	}

}
