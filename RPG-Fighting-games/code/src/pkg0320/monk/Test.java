package pkg0320.monk;

public class Test {

	public static void main(String[] args) {
		Monk ltx = new LuTixia();
		
		ltx.chiZai();
		ltx.daZuo();
		ltx.nianJing();
		ltx.zhuangZhong();
		ltx.xiWu();
		System.out.println(ltx.getName());
		
		if(ltx instanceof Monk) {
			System.out.println("�Ǹ�����");
		}else {
			System.out.println("���Ǻ���");
		}
		
		

	}

}
