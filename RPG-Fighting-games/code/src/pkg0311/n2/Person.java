package pkg0311.n2;

public class Person extends Subject implements Observer, Member {

	private String name;

	public Person(String name) {
		this.name=name;
	}

	public void action() {
		System.out.println(name+"收到盟友通知，加油，我马上到！");
	}

	public void update() {
		System.out.println(name+"受到攻击，请求援救。");
	}

	public void beat() {
		System.out.println("我是"+name+"，我在作战中");
		notifyObserver(name);
	}

}
