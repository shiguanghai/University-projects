package pkg0313.cage_1;

import java.util.ArrayList;

public abstract class Treasure {  //������鱦
 
	protected int id;	//���ر��
	protected double number;  //��������
	private ArrayList<Eudemon> eudemons = new ArrayList<Eudemon>(); //�ػ���

	public Treasure() {
		this.id = 0;
		this.number = 100;
	}
	public Treasure(int id, double number) {
		this.id = id;
		this.number = number;
	}  //���캯��

	public void guard(Eudemon e) {
		eudemons.add(e);
	}
	public void remove(Eudemon e) {
		eudemons.remove(e);
	}	 
	public void notifyEudemon() {
		for(Eudemon e:eudemons) {
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