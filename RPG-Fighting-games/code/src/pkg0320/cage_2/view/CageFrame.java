package pkg0320.cage_2.view;

import javax.swing.JFrame;

public class CageFrame {
	private JFrame  f = new JFrame();

	public CageFrame() {
		f.setSize(500, 300);
		f.add(new MainPanel().getView());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}


}

