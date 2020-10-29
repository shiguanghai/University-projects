package pkg0327.enumdemo;

public class Employee {
	private String name;
	private Gender gender;

	public Employee(String name, Gender gender) {
		super();
		this.name = name;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", gender=" + gender + "]";
	}
	
	
}
