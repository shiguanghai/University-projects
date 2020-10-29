package pkg0403.rcgui.model;


import pkg0403.rcgui.view.LightPanel;

public class Light {
	private boolean on;
	private LightPanel observer;//��ǰ������ѧϰ�۲���ģʽʱ��������һ����̬����洢����۲��ߡ�
	//������һ���ƣ�ֻ��һ���۲��ߡ�

	public Light() {
		on = false;
	}
	public boolean isOn() {
		return on;
	}
	public void turnOn() {
		System.out.println("�ƿ��ˣ�");
		this.on = true;
		observer.update();//ÿ�������Ƶ�״̬ʱ����Ҫ֪ͨ�۲���
	}	
	public void turnOff() {
		System.out.println("�ƹ��ˣ�");
		this.on = false;
		observer.update();//ÿ�������Ƶ�״̬ʱ����Ҫ֪ͨ�۲���
	}
	
	public void register(LightPanel observer) {
		this.observer = observer;
	}

}
