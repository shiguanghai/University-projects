package pkg0313.cage_1;

public abstract class Eudemon {
 
	public void update(double quantity) {//�����˶����ص�ʱ���ػ���Ҫ��ʲô��		
		count(quantity);  //��㱦������
		attacks();  //����
	}
	 
	public void count(double quantity) {//��Ϊ�����ػ����������һ���Ķ�����
		System.out.println("�����������ǰ���У�"+quantity);
	}
	 
	public abstract void attacks();//��Ϊ�����ػ���Ĺ�����������һ���������ǳ���
}
 
