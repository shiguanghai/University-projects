package pkg0403.rcgui.view;

import pkg0403.rcgui.model.Room;

import java.awt.GridLayout;

import javax.swing.JPanel;



public class MainPanel {
	private JPanel view;
	private RCPanel rcView;
	private LightPanel[] lightViews;
	private Room room = new Room(4);

	public MainPanel() {
		view = new JPanel();
		view.setLayout(new GridLayout(1,2));
		
		rcView = new RCPanel(room.getRc());
		view.add(rcView.getView());
		
		lightViews = new LightPanel[room.getNum()];
		JPanel lightArea = new JPanel();
		lightArea.setLayout(new GridLayout(lightViews.length,1));
		for(int i=0;i<lightViews.length;i++) {
			lightArea.add(lightViews[i] = new LightPanel(room.getLights()[i]));
			room.getLights()[i].register(lightViews[i]);
		}
		view.add(lightArea);
	}
	public JPanel getView() {
		return view;
	}
	

}
