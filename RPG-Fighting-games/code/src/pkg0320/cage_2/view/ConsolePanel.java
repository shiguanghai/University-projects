package pkg0320.cage_2.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import pkg0311.cage.Eudemon;

public class ConsolePanel extends Eudemon{
	private JPanel view;
	private BarPanel[] bars = new BarPanel[10];
	private Color color;
	
	public ConsolePanel(Color color) {
		this.color = color;
		view = new JPanel();
		view.setLayout(new GridLayout(1,10));
		for(int i=0;i<10;i++) {
			view.add(bars[i] = new BarPanel(color));
		}
		
	}

	public JPanel getView() {
		return view;
	}

	@Override
	public void attacks() {
		System.out.println("I can only show the number to you!");
	}
}
