package pkg0303.n4;

public abstract class Bookstore {
	private BookBehavoir bookBehavoir;
	public Bookstore(BookBehavoir bookBehavior){
		super();
		this.bookBehavoir=bookBehavior;
	}
	public abstract void display();
	public void discount(){
		bookBehavoir.discount();
	}
}
