package pkg0410.cagegui.view;

import pkg0410.cagegui.model.Cage;
import pkg0410.cagegui.model.Treasure;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class TakePanel {
	private JPanel view;
	private JLabel jlId,jlNum;
	private JTextField jtfId,jtfNum;
	private JButton jbTake;
	private Treasure[] ts;//�����ץȡ���ص���ͼ���鱦��ϰ����
	private Cage cage;//���鱦��ͨ��Cage�����Ա�����ϵCage

	public TakePanel(Treasure[] ts,Cage cage) {
		this.ts = ts;
		this.cage = cage;
		
		view  = new JPanel();
		view.setLayout(new GridLayout(3,2));
		JPanel line1 = new JPanel(); 
		line1.setLayout(new GridLayout(1,2));
		line1.add(jlId = new JLabel("��ţ�"));
		line1.add(jtfId = new JTextField());
		
		JPanel line2 = new JPanel(); 
		line2.setLayout(new GridLayout(1,2));
		line2.add(jlNum = new JLabel("������"));
		line2.add(jtfNum = new JTextField());
		
		view.add(line1);
		view.add(line2);
		view.add(jbTake = new JButton("TAKE"));
		jbTake.addActionListener(new TakeListener());
	}
	
	class TakeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int id = Integer.parseInt(jtfId.getText());
			int num = Integer.parseInt(jtfNum.getText());
			
			cage.take(ts[id], num);			
		}
		
	}

	public JPanel getView() {
		return view;
	}
	
	
}
