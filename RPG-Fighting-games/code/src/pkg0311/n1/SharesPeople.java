package pkg0311.n1;

public class SharesPeople implements SharesListent {

	private String name;
	public SharesPeople(String name){
		this.name=name;
	}

	public void response() {
		System.out.println("���ڷ���֪ͨ�����Ա"+name+"������Ϊ����Ʊ�۸�仯���ȴﵽ5%");
		System.out.println("����"+name+"���յ�֪ͨ");

	}

}
