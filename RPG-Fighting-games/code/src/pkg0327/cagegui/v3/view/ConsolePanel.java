package pkg0327.cagegui.v3.view;

import pkg0327.cagegui.v3.model.Treasure;

import javax.swing.*;
import java.awt.*;

public class ConsolePanel{
	private JPanel view;
	private BarPanel[] bars = new BarPanel[10];
	private Color color;
	
	public ConsolePanel(Treasure[] t, Color color) {
		this.color = color;
		view = new JPanel();
		view.setLayout(new GridLayout(1,10));
		for(int i=0;i<10;i++) {
			//view.add(bars[i] = BarFactory.createBarPanel(color));
			view.add(bars[i] = BarFactory.createBarPanel(color,i));//创建带编号的Bar图
			t[i].guard(bars[i]);
			bars[i].setNum((int)t[i].getNumber());
		}
		
	}

	public JPanel getView() {
		return view;
	}	
}
