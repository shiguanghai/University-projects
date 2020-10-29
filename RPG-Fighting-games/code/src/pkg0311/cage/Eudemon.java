package pkg0311.cage;

public abstract class Eudemon {
 
	public void update(double quantity) {//当有人动宝藏的时候，守护神要干什么？		
		count(quantity);  //清点宝藏数量
		attacks();  //攻击
	}
	 
	public void count(double quantity) {//因为所有守护神点数都是一样的动作。
		System.out.println("清点数量，当前还有："+quantity);
	}
	 
	public abstract void attacks();//因为所有守护神的攻击方法都不一样，所以是抽象。
}
 
