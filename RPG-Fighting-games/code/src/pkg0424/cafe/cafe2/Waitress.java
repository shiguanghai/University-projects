package pkg0424.cafe.cafe2;

import java.util.ArrayList;

public class Waitress {
	PancakeHouseMenu pancakeHouseMenu;
	DinerMenu dinerMenu;
 
	public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
	}
 
	public void printMenu() {
		MenuItem[] items = dinerMenu.getMenuItems();
		for(int i=0;i<items.length;i++) {
			System.out.println(items[i]);
		}
		
		ArrayList<MenuItem> itemsList = pancakeHouseMenu.getMenuItems();
		for(MenuItem i:itemsList) {
			System.out.println(i);
		}
	}	
	
	public void printMenu2() {
		Iterator it = dinerMenu.createIterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		it = pancakeHouseMenu.createIterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
