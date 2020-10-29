package pkg0320.cagegui.v2.model;

public class Scene {
	private Cage cage = new Cage();//游戏场景（Scene）：场景中包括1个角色，5只老虎，7只狮子，500箱黄金，100箱钻石
	private Tiger[] tigers = new Tiger[5];
	private Lion[] lions = new Lion[7];
	private Gold[] golds = new Gold[10];
	private Diamond[] diamonds = new Diamond[10];
	public Scene() {		
		for(int i=0;i<tigers.length;i++) {
			tigers[i] = new Tiger();
		}		
		for(int i=0;i<lions.length;i++) {
			lions[i] = new Lion();
		}		
		for(int i=0;i<golds.length;i++) {
			golds[i] = new Gold(i,100);
			golds[i].guard(tigers[0]);//  2、宝藏可以安排数位守护神看守宝藏guard（Eudemon eudemon）    
		}		
		for(int i=0;i<diamonds.length;i++) {
			diamonds[i] = new Diamond(i,100);
			diamonds[i].guard(tigers[1]); // 2、宝藏可以安排数位守护神看守宝藏guard（Eudemon eudemon）    
			diamonds[i].guard(lions[0]);//  2、宝藏可以安排数位守护神看守宝藏guard（Eudemon eudemon）    
		}			
	}
	public Cage getCage() {
		return cage;
	}
	public void setCage(Cage cage) {
		this.cage = cage;
	}
	public Tiger[] getTigers() {
		return tigers;
	}
	public void setTigers(Tiger[] tigers) {
		this.tigers = tigers;
	}
	public Lion[] getLions() {
		return lions;
	}
	public void setLions(Lion[] lions) {
		this.lions = lions;
	}
	public Gold[] getGolds() {
		return golds;
	}
	public void setGolds(Gold[] golds) {
		this.golds = golds;
	}
	public Diamond[] getDiamonds() {
		return diamonds;
	}
	public void setDiamonds(Diamond[] diamonds) {
		this.diamonds = diamonds;
	}
	

}
