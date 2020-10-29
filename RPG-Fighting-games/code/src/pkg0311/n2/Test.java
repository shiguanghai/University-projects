package pkg0311.n2;

public class Test {

	public static void main(String[] args) {
		Subject subject = new Subject();
		Person p1 = new Person("小李");
		Person p2 = new Person("小张");

		subject.registerObserver(p1);
		subject.registerObserver(p2);

		p1.beat();
		p1.update();
		p2.action();
	}

}
