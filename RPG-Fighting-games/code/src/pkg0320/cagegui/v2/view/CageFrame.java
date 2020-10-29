package pkg0320.cagegui.v2.view;

import javax.swing.JFrame;

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
