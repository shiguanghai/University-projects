package pkg0403.rcgui.model;


import pkg0403.rcgui.view.LightPanel;

public class Light {
	private boolean on;
	private LightPanel observer;//以前我们在学习观察者模式时，都是用一个动态数组存储多个观察者。
	//但现在一个灯，只有一个观察者。

	public Light() {
		on = false;
	}
	public boolean isOn() {
		return on;
	}
	public void turnOn() {
		System.out.println("灯开了！");
		this.on = true;
		observer.update();//每当调整灯的状态时，都要通知观察者
	}	
	public void turnOff() {
		System.out.println("灯关了！");
		this.on = false;
		observer.update();//每当调整灯的状态时，都要通知观察者
	}
	
	public void register(LightPanel observer) {
		this.observer = observer;
	}

}
