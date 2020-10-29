package pkg0320.cage_2.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TakePanel {
	private JPanel view;
	private JLabel jlId,jlNum;
	private JTextField jtfId,jtfNum;
	private JButton jbTake;

	public TakePanel() {
		view  = new JPanel();
		view.setLayout(new GridLayout(3,2));

		JPanel line1 = new JPanel(); 
		line1.setLayout(new GridLayout(1,2));
		line1.add(jlId = new JLabel("±àºÅ£º"));
		line1.add(jtfId = new JTextField());
		
		JPanel line2 = new JPanel(); 
		line2.setLayout(new GridLayout(1,2));
		line2.add(jlNum = new JLabel("ÊýÁ¿£º"));
		line2.add(jtfNum = new JTextField());
		
		view.add(line1);
		view.add(line2);
		view.add(jbTake = new JButton("TAKE"));
	}

	public JPanel getView() {
		return view;
	}


	
	
}
