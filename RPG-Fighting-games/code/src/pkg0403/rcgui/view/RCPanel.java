package pkg0403.rcgui.view;

import pkg0403.rcgui.model.RemoteControl;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;



public class RCPanel {//这个类是遥控器RemoteControl的视图类
	private JPanel view;
	private RemoteControl rc;
	private JButton[][] buttons;

	public RCPanel(RemoteControl rc) {
		this.rc = rc;
		view = new JPanel();
		view.setLayout(new GridLayout(rc.getSlot().length,2));
		buttons = new JButton[rc.getSlot().length][2];
		
		ButtonListener l = new ButtonListener();
		for(int i=0;i<buttons.length;i++) {
			view.add(buttons[i][0] = new JButton("on"));
			view.add(buttons[i][1] = new JButton("off"));
			buttons[i][0].addActionListener(l);
			buttons[i][1].addActionListener(l);
		}		
	}
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			outer:
			for(int i=0;i<buttons.length;i++) {
				for(int j=0;j<buttons[0].length;j++) {
					if(e.getSource() == buttons[i][j]) {
						rc.buttonPressed(i, j);
						break outer;
					}
				}
			}			
		}		
	}

	public JPanel getView() {
		return view;
	}
}
