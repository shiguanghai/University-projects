package pkg0410.adapter;

public class Test {

	public static void main(String[] args) {
		Child boy = new Child();
		Duck duck = new Duck();
		
		boy.setDuck(duck);		
		boy.play();
		
		Turkey turkey = new Turkey();
		boy.setDuck(new Adapter(turkey));
		boy.play();

	}

}
