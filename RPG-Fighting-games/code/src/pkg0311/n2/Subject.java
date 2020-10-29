package pkg0311.n2;

import java.util.ArrayList;

public class Subject {

	protected ArrayList<Observer> observers = new ArrayList<Observer>();
	private Observer observer;

	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	public void deleteObserver(Observer observer) {
		observers.remove(observer);
	}

	public void notifyObserver(String name){
		System.out.println("***"+name+"±»µÐÈË¹¥»÷£¡£¡£¡***");
	}

}
