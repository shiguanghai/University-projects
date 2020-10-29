package pkg0320.cage_2.model;

import pkg0320.cage_2.view.CageFrame;

public class Test {

	public static void main(String[] args) {
		Cage cage = new Cage();
		new CageFrame();

		Tiger[] tigers = new Tiger[5];
		for(int i=0;i<tigers.length;i++) {
			tigers[i] = new Tiger();
		}
		Lion[] lions = new Lion[7];
		for(int i=0;i<lions.length;i++) {
			lions[i] = new Lion();
		}
		Gold[] golds = new Gold[10];
		for(int i=0;i<golds.length;i++) {
			golds[i] = new Gold(i,100);
			golds[i].guard(tigers[0]);
		}
		Diamond[] diamonds = new Diamond[10];
		for(int i=0;i<diamonds.length;i++) {
			diamonds[i] = new Diamond(i,100);
			diamonds[i].guard(tigers[1]);
			diamonds[i].guard(lions[0]);
		}


		cage.take(golds[3], 100);
		cage.take(golds[5], 50);
		cage.take(diamonds[3], 100);
		
	}

}
