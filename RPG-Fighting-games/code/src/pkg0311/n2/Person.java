package pkg0311.n2;

public class Person extends Subject implements Observer, Member {

	private String name;

	public Person(String name) {
		this.name=name;
	}

	public void action() {
		System.out.println(name+"�յ�����֪ͨ�����ͣ������ϵ���");
	}

	public void update() {
		System.out.println(name+"�ܵ�����������Ԯ�ȡ�");
	}

	public void beat() {
		System.out.println("����"+name+"��������ս��");
		notifyObserver(name);
	}

}
