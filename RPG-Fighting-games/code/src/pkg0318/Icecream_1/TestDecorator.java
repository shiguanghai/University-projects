package pkg0318.Icecream_1;

public class TestDecorator {

	public static void main(String[] args) {
		Icecream simpleIcecream = new Simplelceream();
		Icecream nuttyIcecream = new NuttyDecorator(new IcecreamDecorator());

		System.out.println(simpleIcecream.makeIcecream());
		System.out.println(nuttyIcecream.makeIcecream());
	}

}
