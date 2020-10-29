package pkg0403.rcgui.view;

import pkg0403.rcgui.model.Light;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;



public class LightPanel extends JPanel{//这个类是灯Light的视图
	private Light light;

	public LightPanel(Light light) {
		this.light = light;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(light.isOn()) {
			g.setColor(Color.PINK);
		}else {
			g.setColor(Color.BLACK);
		}
		
		g.fillOval(5, 5, 50, 50);
	}
	
	public void update() {//观察者模式，当模型Light状态变化时，要通知视图LightPanel。
		this.repaint();
	}
}
