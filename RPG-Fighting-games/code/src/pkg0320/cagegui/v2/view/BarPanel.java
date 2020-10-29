package pkg0320.cagegui.v2.view;

import pkg0320.cagegui.v2.model.Eudemon;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;



public class BarPanel extends JPanel implements Eudemon {
	private Color color;	
	private int num;//定义一个新的变量，让矩形的高度，随着数量变化；
	
	public BarPanel(Color color) {
		super();
		this.color = color;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
		this.repaint();//每次更动数量，都必须重新绘制，也就是调用paintComponent
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
		g.fill3DRect(5, 100-num, 15, num, true);
	}

	@Override
	public void update(double quantity) {
		this.setNum((int)quantity);		
	}
	public Color getColor() {
		return color;
	}
}
