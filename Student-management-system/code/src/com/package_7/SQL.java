/*
 * 功能：用来和数据库SQLserver进行连接，以及相应的查询方法。
 */
package com.package_7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

//写一个类，用来与数据库建立连接，并且查询数据
class GetSQL {
	// 设定用户名和密码
	static String userword;
	static String pwd;
	
	static String english;
	static String num;
	static String name;
	static String chinese;
	static String zhengzhi;
	static String math;
	
	static String age;
	static String salary;
	static String sex;
	static String zhicheng;
	static String teanum;
	static String teaname;

	static boolean query = false;//判断查询学号是否成功

	static Connection ct = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;

	// 用于连接数据库的方法，可用于子类的继承
	//可通过 https://www.runoob.com/java/java-mysql-connect.html 了解
	public static void ConnectSQL() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// MySQL 8.0 版本 - JDBC 驱动名
			System.out.println("连接数据库...");
			//MySQL在高版本需要指明是否进行SSL(保障Internet数据传输安全利用数据加密)
			//在连接数据url 上添加 useSSL=false
			ct = DriverManager.getConnection//MySQL 8.0 版本 - JDBC 数据库 URL
					("jdbc:mysql://localhost:3306/studentmanager?useSSL=false&serverTimezone=UTC","root","Wzb991216");
			System.out.println("The SQL is connected");
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	// 用于向数据库进行查询的方法
	//在学生表中进行查询
	public static void querystu(String s,String username) {
		// 创建火箭车
		try {
			System.out.println(" 实例化Statement对象...");
			//可通过 https://blog.csdn.net/a153375250/article/details/50946661 了解
			ps = ct.prepareStatement("select * from info_stu where 权限=? and 用户名=? ");
			// 给?赋值(可防止SQL注入漏洞问题)，不要直接使用拼接的方式
			ps.setString(1, s);
			ps.setString(2, username);
			// ResultSet结果集,可以把ResultSet理解成返回一张表行的结果集
			rs = ps.executeQuery();
			// 循环取出
			if (rs.next()) {// 通过字段检索
				// 将教师的用户名和密码取出
				userword = rs.getString(2);//第二列用户名
				pwd = rs.getString(3);//第三列密码
				System.out.println("成功获取到密码和用户名from数据库");
				System.out.println(userword + "\t" + pwd + "\t");
				
				//调用登录方法
			
			}else
			{
				JOptionPane.showMessageDialog(null, "没有此用户，请重新输入！", "提示消息", JOptionPane.WARNING_MESSAGE);
			    
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	//在教师表中进行查询
	public static void querytea(String s,String name ) {
		// 创建火箭车
		try {
			ps = ct.prepareStatement("select * from info_tea where 权限=? and 用户名=? ");
			// 给?赋值(可防止SQL注入漏洞问题)，不要直接使用拼接的方式
			ps.setString(1, s);
			ps.setString(2, name);
			// ResultSet结果集,可以把ResultSet理解成返回一张表行的结果集
			rs = ps.executeQuery();
			// 循环取出
			if (rs.next()) {
				// 将教师的用户名和密码取出
				userword = rs.getString(2);
				pwd = rs.getString(3);
				System.out.println("成功获取到密码和用户名from数据库");
				System.out.println(userword + "\t" + pwd + "\t");
			}else
			{
				JOptionPane.showMessageDialog(null, "没有此用户，请重新输入！", "提示消息", JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	//从数据库中根据学号或者教工号来查询数据，并且填入表格。
	public static void getdatastu(String s) {
		// 创建火箭车
		try {
			ps = ct.prepareStatement("select * from info_stu where 学号 =? ");
			// 给?赋值(可防止SQL注入漏洞问题)，不要直接使用拼接的方式
			ps.setString(1, s);
			// ResultSet结果集,可以把ResultSet理解成返回一张表行的结果集
			rs = ps.executeQuery();
			if(rs.next())	
			{
				query = true; //查询成功 返回true

				// 将学生的用户名和密码取出
				num = rs.getString(4);
				name = rs.getString(5);
				math = rs.getString(6);
				chinese = rs.getString(7);
				english = rs.getString(8);
				zhengzhi = rs.getString(9);
			}else
			{
				query = false; //查询失败 返回false
				JOptionPane.showMessageDialog(null, "沒有此学生，请重新输入", "提示消息", JOptionPane.WARNING_MESSAGE);
			}
	
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void getdatatea(String s) {
		// 创建火箭车
		try {
			ps = ct.prepareStatement("select * from info_tea where 教工号 =? ");
			// 给?赋值(可防止SQL注入漏洞问题)，不要直接使用拼接的方式
			ps.setString(1, s);
			// ResultSet结果集,可以把ResultSet理解成返回一张表行的结果集
			rs = ps.executeQuery();
			if(rs.next())	
			{
				query = true;
				// 将教师的用户名和密码取出
				teanum = rs.getString(4);
				teaname = rs.getString(5);
				sex = rs.getString(6);
				salary = rs.getString(7);
				zhicheng = rs.getString(8);
				age = rs.getString(9);
			}else
			{
				query = false;
				JOptionPane.showMessageDialog(null, "沒有此教师，请重新输入", "提示消息", JOptionPane.WARNING_MESSAGE);
			}
	
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void getnamestu(String s){
		//通过用户名获取用户姓名和学号
		try {
			ps = ct.prepareStatement("select * from info_stu where 用户名 =? ");
			// 给?赋值(可防止SQL注入漏洞问题)，不要直接使用拼接的方式
			ps.setString(1, s);
			// ResultSet结果集,可以把ResultSet理解成返回一张表行的结果集
			rs = ps.executeQuery();
			while(rs.next()){
				//将该学生的姓名和学号取出
				num = rs.getString(4);
				name = rs.getString(5);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void judgenum(String s){
		//通过学号判断是否存在该学生
		try {
			num=s;//将学号赋给num方便修改该学生成绩
			ps = ct.prepareStatement("select * from info_stu where 学号 =? ");
			// 给?赋值(可防止SQL注入漏洞问题)，不要直接使用拼接的方式
			ps.setString(1, s);
			// ResultSet结果集,可以把ResultSet理解成返回一张表行的结果集
			rs = ps.executeQuery();
			if(rs.next()){
				query = true;//学号存在
			}else
			{
				JOptionPane.showMessageDialog(null, "沒有此学生，请重新输入", "提示消息", JOptionPane.WARNING_MESSAGE);
				query = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void setgrade(String math,String chinese,String english,String zhengzhi,String num){
		try {
			ps = ct.prepareStatement("update info_stu set 数学 =?, 语文 =?, 英语 =?, 政治 =? WHERE (学号 =?)");
			ps.setString(1, math);
			ps.setString(2, chinese);
			ps.setString(3, english);
			ps.setString(4, zhengzhi);
			ps.setString(5, num);
			ps.executeUpdate();//修改数据

			System.out.println("数据库信息已修改");
			JOptionPane.showMessageDialog(null,"修改成功！","提示消息",JOptionPane.WARNING_MESSAGE);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 给?赋值(可防止SQL注入漏洞问题)，不要直接使用拼接的方式


	}
	
}