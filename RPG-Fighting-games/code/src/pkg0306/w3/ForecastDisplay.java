package pkg0306.w3;

public class ForecastDisplay implements Observer {

	public void update(double t, double h, double p) {
		System.out.println("T = "+t);
		System.out.println("H = "+h);
		System.out.println("P = "+p);
	}



}
