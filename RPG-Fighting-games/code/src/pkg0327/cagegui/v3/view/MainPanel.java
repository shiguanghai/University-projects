package pkg0327.cagegui.v3.view;

import pkg0327.cagegui.v3.model.Scene;

import javax.swing.*;
import java.awt.*;

public class MainPanel {
	private JPanel view;
	private TakePanel goldTakePanel,diamondTakePanel;
	private ConsolePanel goldConsolePanel,diamondConsolPanel;
	private Scene scene = new Scene();

	public MainPanel() {
		view = new JPanel();
		view.setLayout(new GridLayout(2,2));
		goldTakePanel = new TakePanel(scene.getGolds(),scene.getCage());
		diamondTakePanel = new TakePanel(scene.getDiamonds(),scene.getCage());
		goldConsolePanel = new ConsolePanel(scene.getGolds(),Color.YELLOW);
		diamondConsolPanel = new ConsolePanel(scene.getDiamonds(),Color.BLUE);
		view.add(goldTakePanel.getView());
		view.add(goldConsolePanel.getView());
		view.add(diamondTakePanel.getView());
		view.add(diamondConsolPanel.getView());
	}

	public JPanel getView() {
		return view;
	}
	
	
}
