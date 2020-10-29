package pkg0410.cagegui.view;

import javax.swing.JFrame;

public class CageFrame {
	private JFrame  f = new JFrame("¹ú¼Ò±¦²Ø");

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
