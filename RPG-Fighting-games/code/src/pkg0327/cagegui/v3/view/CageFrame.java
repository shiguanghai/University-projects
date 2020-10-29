package pkg0327.cagegui.v3.view;

import javax.swing.*;

public class CageFrame {
	private JFrame  f = new JFrame();

	public CageFrame() {
		f.setSize(500, 300);
		f.add(new MainPanel().getView());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	public static void main(String[] args) {	
		new CageFrame();
	}

}
