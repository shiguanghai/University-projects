package pkg0403.rcgui.view;

import javax.swing.JFrame;

public class MainFrame {
	private JFrame  f = new JFrame("Ò£¿ØÆ÷");

	public MainFrame() {
		f.setSize(300, 300);
		f.add(new MainPanel().getView());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	public static void main(String[] args) {	
		new MainFrame();
	}

}
