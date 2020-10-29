package pkg0422.n2;

public class Student extends PrepareGotoSchool {

	public Student() {
		System.out.println("I am a Student");
	}

	@Override
	public void dressUp() {
		System.out.println("Wear a school uniform");
	}

	@Override
	public void eatBreakfast() {
		System.out.println("Eat bread");
	}


	public void takeThings() {
		System.out.println("Take the homework");
	}

}
