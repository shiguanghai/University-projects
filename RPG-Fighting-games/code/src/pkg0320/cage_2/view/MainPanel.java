package pkg0320.cage_2.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class MainPanel {
	private JPanel view;
	private TakePanel goldTakePanel,diamondTakePanel;
	private ConsolePanel goldConsolePanel,diamondConsolPanel;

	public MainPanel() {
		view = new JPanel();
		view.setLayout(new GridLayout(2,2));
		goldTakePanel = new TakePanel();
		diamondTakePanel = new TakePanel();
		goldConsolePanel = new ConsolePanel(Color.YELLOW);
		diamondConsolPanel = new ConsolePanel(Color.BLUE);
		view.add(goldTakePanel.getView());
		view.add(goldConsolePanel.getView());
		view.add(diamondTakePanel.getView());
		view.add(diamondConsolPanel.getView());

	}

	public JPanel getView() {
		return view;
	}
	
	
}
