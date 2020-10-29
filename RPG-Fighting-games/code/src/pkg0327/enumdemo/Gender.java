package pkg0327.enumdemo;

public class Gender {
	private int value;
	public static final Gender FEMALE = new Gender(0);
	public static final Gender MALE = new Gender(1);

	private Gender(int value) {
		this.value = value;		
	}
	
	public String toString() {
		return value == 0 ? "Å®" : "ÄÐ"; 
	}
	
}
