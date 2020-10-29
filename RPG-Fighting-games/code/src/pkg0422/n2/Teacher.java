package pkg0422.n2;

public class Teacher extends PrepareGotoSchool {
	public Teacher() {
		System.out.println("I am a teacher");
	}

	@Override
	public void dressUp() {
		System.out.println("Suit up");
	}

	@Override
	public void eatBreakfast() {
		System.out.println("Eat eggs");
	}


	public void takeThings() {
		System.out.println("Take the homework");
	}

}
