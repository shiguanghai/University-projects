package pkg0311.n1;

import java.util.ArrayList;

public abstract class Shares {

	protected ArrayList<SharesPeople> people = new ArrayList<SharesPeople>();

	public void attach(SharesPeople sharespeople){
		people.add(sharespeople);
	}

	public void remove(SharesPeople sharespeople){
		people.remove(sharespeople);
	}

	public abstract void notifyPeople(int num);


}
