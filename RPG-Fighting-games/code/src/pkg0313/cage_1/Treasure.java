package pkg0313.cage_1;

import java.util.ArrayList;

public abstract class Treasure {  //抽象的珠宝
 
	protected int id;	//宝藏编号
	protected double number;  //宝藏数量
	private ArrayList<Eudemon> eudemons = new ArrayList<Eudemon>(); //守护神

	public Treasure() {
		this.id = 0;
		this.number = 100;
	}
	public Treasure(int id, double number) {
		this.id = id;
		this.number = number;
	}  //构造函数

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
	}  //观察者管理方法
	public double getNumber() {
		return number;
	}
	public void setNumber(double number) {
		this.number = number;
		notifyEudemon();
	}  //每次修改数量 通知观察者
	public int getId() {
		return id;
	}	 
}