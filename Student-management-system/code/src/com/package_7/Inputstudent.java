package com.package_7;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inputstudent extends JDialog implements ActionListener {
    //�������
    JButton jbt,jbt2 = null;
    JLabel jlb,jlb2=null;
    JTable table = null;
    JScrollPane jsp = null;
    DefaultTableModel model = null;
    JPanel jp,jp2 = null;

    public Inputstudent(JFrame owner){
        super(owner,"�޸ĳɼ�");

        jbt = new JButton("���³ɼ�");
        jbt2 = new JButton("����");

        String[] grade = { "��ѧ", "����", "Ӣ��", "����" };
        model = new DefaultTableModel(grade, 1);
        table = new JTable(model);
        jsp = new JScrollPane(table);

        //����
        jp=new JPanel();
        jp2=new JPanel();

        jp.add(jsp);
        jp2.add(jbt);
        jp2.add(jbt2);

        this.add(jp);
        this.add(jp2);

        jbt.addActionListener(this);
        jbt2.addActionListener(this);

        this.setLayout(new GridLayout(2,2));
        this.setSize(500, 150);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("���³ɼ�")){
            if((table.getValueAt(0,0)!=null)&&(table.getValueAt(0,0)!=null)&&
                    (table.getValueAt(0,0)!=null)&&(table.getValueAt(0,0)!=null)){
                GetSQL.setgrade((String) table.getValueAt(0,0),
                        (String) table.getValueAt(0,1),
                        (String) table.getValueAt(0,2),
                        (String) table.getValueAt(0,3),
                        GetSQL.num);
            }
            else {
                JOptionPane.showMessageDialog(null, "�ɼ�����Ϊ��", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
            }

        } else if(e.getActionCommand().equals("����")) {
            table.setValueAt(null,0,0);
            table.setValueAt(null,0,1);
            table.setValueAt(null,0,2);
            table.setValueAt(null,0,3);
        }

    }
}
