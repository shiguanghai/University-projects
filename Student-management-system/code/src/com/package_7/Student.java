/*
 * 功能：学生登录成功界面。
 * 
 */
package com.package_7;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Student extends JFrame implements ActionListener
{

	     //定义组件
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
	    //构造函数
		public Student()    //不能申明为void!!!!!否则弹不出新界面
		{

			//创建组件
			jb1=new JButton("成绩查询");

			//创建成绩查询窗口
			String[] grade = { "数学", "语文", "英语", "政治" };
			mymodel = new DefaultTableModel(grade, 1);
			mytable = new JTable(mymodel);
			myjsp = new JScrollPane(mytable);

			//布局
			jp1=new JPanel();
			jp2=new JPanel();
			jp3=new JPanel();

			GetSQL.getnamestu(GetSQL.userword);
			jlb1=new JLabel("学生姓名: "+GetSQL.name+"      ");//数据库动态获取当前学生姓名
			jlb2=new JLabel("学号: "+GetSQL.num+"  ");
			jlb3=new JLabel("最新公告：");
			jlb4=new JLabel("我校期末考核将于2019.12.30举行");
			
			jp1.add(jlb1);
			jp1.add(jlb2);
			jp1.add(jb1);
			jp2.add(myjsp);
			jp3.add(jlb3);
			jp3.add(jlb4);

			//设置监听
			jb1.addActionListener(this);

			this.add(jp1,BorderLayout.NORTH);
			this.add(jp2,BorderLayout.SOUTH);
			this.add(jp3,BorderLayout.CENTER);
			
			//设置布局管理器
			this.setLayout(new GridLayout(3,3,50,50));
			this.setTitle("学生成绩管理系统-学生");
			this.setSize(500,300);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
			this.setResizable(false);



}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals("成绩查询") ){
				GetSQL.getdatastu(GetSQL.num);
				// 将数据填入表格
				mytable.setValueAt(GetSQL.math, 0, 0);
				mytable.setValueAt(GetSQL.chinese, 0, 1);
				mytable.setValueAt(GetSQL.english, 0, 2);
				mytable.setValueAt(GetSQL.zhengzhi, 0, 3);
			}
		}
}
