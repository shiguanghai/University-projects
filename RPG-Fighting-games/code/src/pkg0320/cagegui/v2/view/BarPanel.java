package pkg0320.cagegui.v2.view;

import pkg0320.cagegui.v2.model.Eudemon;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;



public class BarPanel extends JPanel implements Eudemon {
	private Color color;	
	private int num;//����һ���µı������þ��εĸ߶ȣ����������仯��
	
	public BarPanel(Color color) {
		super();
		this.color = color;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
		this.repaint();//ÿ�θ������������������»��ƣ�Ҳ���ǵ���paintComponent
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
