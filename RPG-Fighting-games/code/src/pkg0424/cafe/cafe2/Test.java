package pkg0424.cafe.cafe2;

public class Test {

	public static void main(String[] args) {
		DinerMenu menu1 = new DinerMenu();
		PancakeHouseMenu menu2 = new PancakeHouseMenu();
		Waitress w = new Waitress(menu2,menu1);
		
		w.printMenu2();

	}

}
