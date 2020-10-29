package pkg0403.rcgui.view;

import pkg0403.rcgui.model.Light;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;



public class LightPanel extends JPanel{//������ǵ�Light����ͼ
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
	
	public void update() {//�۲���ģʽ����ģ��Light״̬�仯ʱ��Ҫ֪ͨ��ͼLightPanel��
		this.repaint();
	}
}
