package pkg0410.cagegui.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import pkg0410.cagegui.model.Treasure;

public class ConsolePanel{
	private JPanel view;
	private BarPanel[] bars = new BarPanel[10];
	private Color color;
	
	public ConsolePanel(Treasure[] t,Color color) {
		this.color = color;
		view = new JPanel();
		view.setLayout(new GridLayout(1,10));
		for(int i=0;i<10;i++) {
			//view.add(bars[i] = BarFactory.createBarPanel(color);
			view.add(bars[i] = BarFactory.createBarPanel(color,i));
			t[i].guard(bars[i]);
			bars[i].setNum((int)t[i].getNumber());
		}
		
	}

	public JPanel getView() {
		return view;
	}	
}
