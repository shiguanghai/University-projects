package pkg0306.w3;

public class StaticsDisplay implements Observer {

	public void update(double t, double h, double p) {
		System.out.println("=======================");
		System.out.println("T: "+t+"H: "+h+"P: "+p);
		System.out.println("=======================");
	}

}
