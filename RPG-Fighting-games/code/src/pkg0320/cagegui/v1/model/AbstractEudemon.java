package pkg0320.cagegui.v1.model;

public abstract class AbstractEudemon implements Eudemon,Beast{
 
	public void update(double quantity) {//�����˶����ص�ʱ���ػ���Ҫ��ʲô��		
		count(quantity);
		attacks();
	}
	 
	public void count(double quantity) {//��Ϊ�����ػ����������һ���Ķ�����
		System.out.println("�����������ǰ���У�"+quantity);
	}
	
}
 