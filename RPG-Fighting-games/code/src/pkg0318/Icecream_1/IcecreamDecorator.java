package pkg0318.Icecream_1;

public class IcecreamDecorator implements Icecream {

	protected Icecream icecream;

	public IcecreamDecorator(Icecream icecream) {
		this.icecream=icecream;
	}

	public IcecreamDecorator() {
	}

	public String makeIcecream(){
		return "make SpecialIcecream";
	}

}
