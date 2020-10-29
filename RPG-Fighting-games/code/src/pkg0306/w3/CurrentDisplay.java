package pkg0306.w3;

public class CurrentDisplay implements Observer {

	public void update(double t, double h, double p) {
		System.out.println("*************************");
		System.out.println("***Temprature"+t+"***");
		System.out.println("***Humidity"+h+"***");
		System.out.println("***Pressure"+p+"***");
		System.out.println("*************************");
	}

}
