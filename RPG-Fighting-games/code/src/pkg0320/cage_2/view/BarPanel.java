package pkg0320.cage_2.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BarPanel extends JPanel {
	private Color color;	
	public BarPanel(Color color) {
		super();
		this.color = color;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
		g.fill3DRect(5, 5, 15, 100, true);
	}
}
