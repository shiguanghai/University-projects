package pkg0320.cage_2.model;

import java.util.ArrayList;

public abstract class Treasure {  //������鱦
 
	protected int id;	//���ر��
	protected double number;  //��������
	private ArrayList<AbstractEudemon> eudemons = new ArrayList<AbstractEudemon>(); //�ػ���

	public Treasure() {
		this.id = 0;
		this.number = 100;
	}
	public Treasure(int id, double number) {
		this.id = id;
		this.number = number;
	}  //���캯��

	public void guard(AbstractEudemon e) {
		eudemons.add(e);
	}
	public void remove(AbstractEudemon e) {
		eudemons.remove(e);
	}	 
	public void notifyEudemon() {
		for(AbstractEudemon e:eudemons) {
			e.update(number);
		}
	}  //�۲��߹�����
	public double getNumber() {
		return number;
	}
	public void setNumber(double number) {
		this.number = number;
		notifyEudemon();
	}  //ÿ���޸����� ֪ͨ�۲���
	public int getId() {
		return id;
	}	 
}