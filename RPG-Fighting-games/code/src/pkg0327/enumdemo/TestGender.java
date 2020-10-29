package pkg0327.enumdemo;

public class TestGender {

	public static void main(String[] args) {
		Employee e1 = new Employee("Tom",Gender.MALE);
		Employee e2 = new Employee("Rose",Gender.FEMALE);
		
		System.out.println(e1);
		System.out.println(e2);

	}

}
