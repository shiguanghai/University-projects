/*
 * 功能：实现了查询学生和老师的信息，并且显示在表格中的功能。
 */

package com.package_7;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Teacher extends JFrame implements ActionListener {

	// 定义组件
	JLabel jl2,jl,jl3,jl4 = null;
	JTextField jtf,jtf2 = null;
	JButton jb,jb2,jb3,jb4,jb5= null;
	JPanel jp1, jp2,jp3,jp4,jp5,jp6 = null;

	DefaultTableModel model,model2 = null;
	JTable table,table2 = null;
	JScrollPane jsp,jsp2 = null;
	static int i,j= 0;//表格的行数
	Inputstudent inputstudent;

//	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Teacher6 t = new Teacher6();
//	}

	// 构造函数
	public Teacher() {
		// 创建组件		
		jl = new JLabel("请输入学号：");
		jl2=new JLabel("请输入教工号：");	
		
		jl3=new JLabel("学生信息表：");
		jl4=new JLabel("教师信息表：");
		
		jtf = new JTextField(10);
		jtf2 = new JTextField(10);
		jb = new JButton("查询1");
		jb2 = new JButton("查询2");
		jb3 = new JButton("重置1");
		jb4	= new JButton("重置2");
		jb5 = new JButton("修改成绩");
		// 设置监听
		jb.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		// 设置表格1
		String[] colnames = { "姓名", "学号", "数学", "语文", "英语", "政治" };
		model = new DefaultTableModel(colnames, 3);
		table = new JTable(model);
		jsp = new JScrollPane(table);
		//设置表格2
		String[] col = { "姓名", "教工号", "性别", "工资", "职称", "年龄" };
		model2 = new DefaultTableModel(col, 3);
		table2 = new JTable(model2);
		jsp2 = new JScrollPane(table2);
		
		//布局
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		jp6 = new JPanel();
		jp5.setLayout(new BorderLayout());
		jp6.setLayout(new BorderLayout());
		//学号输入查询栏
		jp1.add(jl);
		jp1.add(jtf);
		jp1.add(jb);
		jp1.add(jb3);
		jp1.add(jb5);
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp1.setPreferredSize(new Dimension(20,20));
		//教工号输入查询栏
		jp3.add(jl2);
		jp3.add(jtf2);
		jp3.add(jb2);
		jp3.add(jb4);
		jp3.setLayout(new FlowLayout(FlowLayout.LEFT));
		//表格
		jp2.add(jsp);
		jp4.add(jsp2);
		//为表格添加说明
		jp5.add(jl3,BorderLayout.SOUTH);
		jp6.add(jl4,BorderLayout.SOUTH);

		this.add(jp1);
		this.add(jp5);
		this.add(jp2);
		this.add(jp3);
		this.add(jp6);
		this.add(jp4);
		
		this.setLayout(new GridLayout(6, 1));
		this.setTitle("学生成绩管理系统—教师");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("查询1")  &&!jtf.getText().isEmpty()) {
			if(i==3){
				JOptionPane.showMessageDialog(null,"查询达到上限！\n请重置后再次输入","提示消息",JOptionPane.ERROR_MESSAGE);
				jtf.setText("");
			}
			else {
				// 当点击查询按钮1时，首先与数据库建立连接
				GetSQL.ConnectSQL();
				GetSQL.getdatastu(jtf.getText());
				jtf.setText("");

				// 将数据填入表格
				if(GetSQL.query) {
					table.setValueAt(GetSQL.name, i, 0);
					table.setValueAt(GetSQL.num, i, 1);
					table.setValueAt(GetSQL.math, i, 2);
					table.setValueAt(GetSQL.chinese, i, 3);
					table.setValueAt(GetSQL.english, i, 4);
					table.setValueAt(GetSQL.zhengzhi, i, 5);
					i++;
				}
			}
		}else if (e.getActionCommand().equals("查询2")  &&!jtf2.getText().isEmpty())
		{
			if(j==3){
				JOptionPane.showMessageDialog(null,"查询框达到上限！\n请重置后再次输入","提示消息",JOptionPane.ERROR_MESSAGE);
				jtf2.setText("");
			}
			else {
				// 当点击查询按钮1时，首先与数据库建立连接
				GetSQL.ConnectSQL();
				GetSQL.getdatatea(jtf2.getText());
				jtf2.setText("");

				// 将数据填入表格
				if(GetSQL.query) {
					table2.setValueAt(GetSQL.teaname, j, 0);
					table2.setValueAt(GetSQL.teanum, j, 1);
					table2.setValueAt(GetSQL.sex, j, 2);
					table2.setValueAt(GetSQL.salary, j, 3);
					table2.setValueAt(GetSQL.zhicheng, j, 4);
					table2.setValueAt(GetSQL.age, j, 5);
					j++;
				}
			}
		} else if(e.getActionCommand().equals("重置1"))
		{
			this.clear1();
		} else if(e.getActionCommand().equals("重置2"))
		{
			this.clear2();
		} else if(e.getActionCommand().equals("修改成绩")&&!jtf.getText().isEmpty()) {
			//首先与数据库建立连接判断是否存在该学生
			GetSQL.ConnectSQL();
			GetSQL.judgenum(jtf.getText());
			jtf.setText("");

			if(inputstudent==null&&GetSQL.query){
				inputstudent = new Inputstudent(this);
				inputstudent.setVisible(true);
			}
		} else
		{
			JOptionPane.showMessageDialog(null , "请输入要查询的编号","提示消息",JOptionPane.WARNING_MESSAGE);
		}

	}
	public	void clear1()
	{
		i=0;
		for(int r=0;r<3;r++){
			table.setValueAt(null, r, 0);
			table.setValueAt(null, r, 1);
			table.setValueAt(null, r, 2);
			table.setValueAt(null, r, 3);
			table.setValueAt(null, r, 4);
			table.setValueAt(null, r, 5);
		}
	}
	public	void clear2()
	{
		j=0;
		for(int r=0;r<3;r++){
			table2.setValueAt(null, r, 0);
			table2.setValueAt(null, r, 1);
			table2.setValueAt(null, r, 2);
			table2.setValueAt(null, r, 3);
			table2.setValueAt(null, r, 4);
			table2.setValueAt(null, r, 5);
		}
	}
}
