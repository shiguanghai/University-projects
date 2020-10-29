package pkg0320.cage_2.model;

import java.util.ArrayList;

public abstract class Treasure {  //抽象的珠宝
 
	protected int id;	//宝藏编号
	protected double number;  //宝藏数量
	private ArrayList<AbstractEudemon> eudemons = new ArrayList<AbstractEudemon>(); //守护神

	public Treasure() {
		this.id = 0;
		this.number = 100;
	}
	public Treasure(int id, double number) {
		this.id = id;
		this.number = number;
	}  //构造函数

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