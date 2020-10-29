package pkg0410.cagegui.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import pkg0410.cagegui.model.CageMemDecorator;
import pkg0410.cagegui.model.Scene;

public class MainPanel {
	private JPanel view;
	private TakePanel goldTakePanel,diamondTakePanel;
	private ConsolePanel goldConsolePanel,diamondConsolPanel;
	private Scene scene = new Scene();
	private JButton jbUndo;

	public MainPanel() {
		view = new JPanel();
		view.setLayout(new BorderLayout());
		
		JPanel upper = new JPanel();
		upper.setLayout(new GridLayout(2,2));
		goldTakePanel = new TakePanel(scene.getGolds(),scene.getCage());
		diamondTakePanel = new TakePanel(scene.getDiamonds(),scene.getCage());
		goldConsolePanel = new ConsolePanel(scene.getGolds(),Color.YELLOW);
		diamondConsolPanel = new ConsolePanel(scene.getDiamonds(),Color.BLUE);
		upper.add(goldTakePanel.getView());
		upper.add(goldConsolePanel.getView());
		upper.add(diamondTakePanel.getView());
		upper.add(diamondConsolPanel.getView());
		
		view.add(upper,BorderLayout.CENTER);
		view.add(jbUndo = new JButton("UNDO"),BorderLayout.SOUTH);
		jbUndo.addActionListener(new UndoListener());
	}

	class UndoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			CageMemDecorator cage = (CageMemDecorator)(scene.getCage());
			cage.undo();
		}
		
	}
	public JPanel getView() {
		return view;
	}
	
	
}
