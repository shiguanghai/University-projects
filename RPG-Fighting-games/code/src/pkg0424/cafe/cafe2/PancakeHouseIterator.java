package pkg0424.cafe.cafe2;

import java.util.ArrayList;

public class PancakeHouseIterator implements Iterator {
	private ArrayList<MenuItem> items;
	private int pointer = 0;	
	public PancakeHouseIterator(ArrayList<MenuItem> items) {
		super();
		this.items = items;
	}

	@Override
	public boolean hasNext() {		
		return pointer < items.size();
	}

	@Override
	public MenuItem next() {		
		return items.get(pointer++);
	}

}
