package pkg0320.cage_2.model;

public abstract class AbstractEudemon {
 
	public void update(double quantity) {//�����˶����ص�ʱ���ػ���Ҫ��ʲô��		
		count(quantity);  //��㱦������
		attacks();  //����
	}
	 
	public void count(double quantity) {//��Ϊ�����ػ����������һ���Ķ�����
		System.out.println("�����������ǰ���У�"+quantity);
	}
	 
	public abstract void attacks();//��Ϊ�����ػ���Ĺ�����������һ���������ǳ���
}
 
