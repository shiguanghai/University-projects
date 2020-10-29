package pkg0303.n4;

public class ComputerBook extends Bookstore {
	ComputerBook(){
		super(new Option1());
	}
	public void display() {
		System.out.println("I am ComputerBook.");
	}

}
