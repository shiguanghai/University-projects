package pkg0311.n3;

public class Tiger implements Eudemon {

	public void Update() {
		System.out.println("我是老虎，宝藏状态已经变动");
		attacks();
	}

	public void attacks() {
		System.out.println("老虎攻击！！！");
	}

}
