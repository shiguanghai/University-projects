package pkg0311.n3;

public class Lion implements Eudemon {

	public void Update() {
		System.out.println("我是狮子，宝藏状态已经变动");
		attacks();
	}

	public void attacks() {
		System.out.println("狮子攻击！！！");
	}

}
