package pkg0311.n3;



import java.util.Vector;

public abstract class Treasure {
	private String state = "N";
	private Vector Obs = new Vector();

	public void guard(Eudemon e) {
		Obs.add(e);
	}

	public void notifyall() {
		if(Obs.size()!=0){
			System.out.println("守护者数量："+count());
			for(int i=0;i<Obs.size();i++){
				((Eudemon)Obs.get(i)).Update();
			}
		}else{

		}
	}

	public boolean hasChanges() {
		if(state.equalsIgnoreCase("N")){
			return false;
		}else {
			return true;
		}
	}

	public void setChanged() {
		if(state.equalsIgnoreCase("N")){
			state="Y";
		}else {
			state="N";
		}
		notifyall();
	}

	public void clearChanged() {
		state = "N";
	}

	public int count() {
		return Obs.size();
	}

}
