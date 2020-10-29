package pkg0410.cagegui.model;

public abstract class AbstractEudemon implements Eudemon,Beast{
 
	public void update(double quantity) {//当有人动宝藏的时候，守护神要干什么？		
		count(quantity);
		attacks();
	}
	 
	public void count(double quantity) {//因为所有守护神点数都是一样的动作。
		System.out.println("清点数量，当前还有："+quantity);
	}
	
}
 
