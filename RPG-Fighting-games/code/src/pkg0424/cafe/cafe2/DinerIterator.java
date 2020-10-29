package pkg0424.cafe.cafe2;

public class DinerIterator implements Iterator {
	private MenuItem[] items;
	private int pointer = 0;
	
	public DinerIterator(MenuItem[] items) {
		super();
		this.items = items;
	}

	@Override
	public boolean hasNext() {
		return pointer < items.length;
	}

	@Override
	public MenuItem next() {		
		return items[pointer++];
	}

}
