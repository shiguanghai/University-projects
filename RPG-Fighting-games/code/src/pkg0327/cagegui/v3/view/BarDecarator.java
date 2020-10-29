package pkg0327.cagegui.v3.view;

import java.awt.*;

public class BarDecarator extends BarPanel {

	private BarPanel barPanel;
	private int id;

	public BarDecarator(int id, BarPanel barPanel) {
		super(barPanel.getColor());
		this.barPanel = barPanel;
		this.id = id;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawString(""+id, 8, 115);
	}

	

}
