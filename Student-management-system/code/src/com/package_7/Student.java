/*
 * ���ܣ�ѧ����¼�ɹ����档
 * 
 */
package com.package_7;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Student extends JFrame implements ActionListener
{

	     //�������
		JButton jb1=null;
		JPanel jp1,jp2,jp3=null;
		JLabel jlb1,jlb2,jlb3,jlb4=null;
		JTable mytable = null;
		JScrollPane myjsp = null;
	    DefaultTableModel mymodel = null;
		
//		public static void main(String[] args) {
//			// TODO Auto-generated method stub
//			Stu_UI6  ui=new Stu_UI6();
//		}	
	    //���캯��
		public Student()    //��������Ϊvoid!!!!!���򵯲����½���
		{

			//�������
			jb1=new JButton("�ɼ���ѯ");

			//�����ɼ���ѯ����
			String[] grade = { "��ѧ", "����", "Ӣ��", "����" };
			mymodel = new DefaultTableModel(grade, 1);
			mytable = new JTable(mymodel);
			myjsp = new JScrollPane(mytable);

			//����
			jp1=new JPanel();
			jp2=new JPanel();
			jp3=new JPanel();

			GetSQL.getnamestu(GetSQL.userword);
			jlb1=new JLabel("ѧ������: "+GetSQL.name+"      ");//���ݿ⶯̬��ȡ��ǰѧ������
			jlb2=new JLabel("ѧ��: "+GetSQL.num+"  ");
			jlb3=new JLabel("���¹��棺");
			jlb4=new JLabel("��У��ĩ���˽���2019.12.30����");
			
			jp1.add(jlb1);
			jp1.add(jlb2);
			jp1.add(jb1);
			jp2.add(myjsp);
			jp3.add(jlb3);
			jp3.add(jlb4);

			//���ü���
			jb1.addActionListener(this);

			this.add(jp1,BorderLayout.NORTH);
			this.add(jp2,BorderLayout.SOUTH);
			this.add(jp3,BorderLayout.CENTER);
			
			//���ò��ֹ�����
			this.setLayout(new GridLayout(3,3,50,50));
			this.setTitle("ѧ���ɼ�����ϵͳ-ѧ��");
			this.setSize(500,300);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
			this.setResizable(false);



}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals("�ɼ���ѯ") ){
				GetSQL.getdatastu(GetSQL.num);
				// ������������
				mytable.setValueAt(GetSQL.math, 0, 0);
				mytable.setValueAt(GetSQL.chinese, 0, 1);
				mytable.setValueAt(GetSQL.english, 0, 2);
				mytable.setValueAt(GetSQL.zhengzhi, 0, 3);
			}
		}
}
