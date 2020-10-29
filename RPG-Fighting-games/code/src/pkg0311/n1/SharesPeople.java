package pkg0311.n1;

public class SharesPeople implements SharesListent {

	private String name;
	public SharesPeople(String name){
		this.name=name;
	}

	public void response() {
		System.out.println("正在发送通知股民成员"+name+"。内容为：股票价格变化幅度达到5%");
		System.out.println("股民"+name+"已收到通知");

	}

}
