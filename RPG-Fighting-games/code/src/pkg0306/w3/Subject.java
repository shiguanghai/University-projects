package pkg0306.w3;

import java.util.ArrayList;

public class Subject {

	private ArrayList<Observer> observers = new ArrayList<Observer>();


	private Observer observer;

	public void register(Observer o) {
		observers.add(o);
	}
	public void remove(Observer o) {
		observers.remove(o);
	}

	public void notifyObservers(double t,double h,double p){
		for(Observer o:observers){
			o.update(t,h,p);
		}
	}



}
