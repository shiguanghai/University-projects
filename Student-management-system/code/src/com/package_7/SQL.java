/*
 * ���ܣ����������ݿ�SQLserver�������ӣ��Լ���Ӧ�Ĳ�ѯ������
 */
package com.package_7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

//дһ���࣬���������ݿ⽨�����ӣ����Ҳ�ѯ����
class GetSQL {
	// �趨�û���������
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

	static boolean query = false;//�жϲ�ѯѧ���Ƿ�ɹ�

	static Connection ct = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;

	// �����������ݿ�ķ���������������ļ̳�
	//��ͨ�� https://www.runoob.com/java/java-mysql-connect.html �˽�
	public static void ConnectSQL() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// MySQL 8.0 �汾 - JDBC ������
			System.out.println("�������ݿ�...");
			//MySQL�ڸ߰汾��Ҫָ���Ƿ����SSL(����Internet���ݴ��䰲ȫ�������ݼ���)
			//����������url ����� useSSL=false
			ct = DriverManager.getConnection//MySQL 8.0 �汾 - JDBC ���ݿ� URL
					("jdbc:mysql://localhost:3306/studentmanager?useSSL=false&serverTimezone=UTC","root","Wzb991216");
			System.out.println("The SQL is connected");
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	// ���������ݿ���в�ѯ�ķ���
	//��ѧ�����н��в�ѯ
	public static void querystu(String s,String username) {
		// ���������
		try {
			System.out.println(" ʵ����Statement����...");
			//��ͨ�� https://blog.csdn.net/a153375250/article/details/50946661 �˽�
			ps = ct.prepareStatement("select * from info_stu where Ȩ��=? and �û���=? ");
			// ��?��ֵ(�ɷ�ֹSQLע��©������)����Ҫֱ��ʹ��ƴ�ӵķ�ʽ
			ps.setString(1, s);
			ps.setString(2, username);
			// ResultSet�����,���԰�ResultSet���ɷ���һ�ű��еĽ����
			rs = ps.executeQuery();
			// ѭ��ȡ��
			if (rs.next()) {// ͨ���ֶμ���
				// ����ʦ���û���������ȡ��
				userword = rs.getString(2);//�ڶ����û���
				pwd = rs.getString(3);//����������
				System.out.println("�ɹ���ȡ��������û���from���ݿ�");
				System.out.println(userword + "\t" + pwd + "\t");
				
				//���õ�¼����
			
			}else
			{
				JOptionPane.showMessageDialog(null, "û�д��û������������룡", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			    
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	//�ڽ�ʦ���н��в�ѯ
	public static void querytea(String s,String name ) {
		// ���������
		try {
			ps = ct.prepareStatement("select * from info_tea where Ȩ��=? and �û���=? ");
			// ��?��ֵ(�ɷ�ֹSQLע��©������)����Ҫֱ��ʹ��ƴ�ӵķ�ʽ
			ps.setString(1, s);
			ps.setString(2, name);
			// ResultSet�����,���԰�ResultSet���ɷ���һ�ű��еĽ����
			rs = ps.executeQuery();
			// ѭ��ȡ��
			if (rs.next()) {
				// ����ʦ���û���������ȡ��
				userword = rs.getString(2);
				pwd = rs.getString(3);
				System.out.println("�ɹ���ȡ��������û���from���ݿ�");
				System.out.println(userword + "\t" + pwd + "\t");
			}else
			{
				JOptionPane.showMessageDialog(null, "û�д��û������������룡", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	//�����ݿ��и���ѧ�Ż��߽̹�������ѯ���ݣ�����������
	public static void getdatastu(String s) {
		// ���������
		try {
			ps = ct.prepareStatement("select * from info_stu where ѧ�� =? ");
			// ��?��ֵ(�ɷ�ֹSQLע��©������)����Ҫֱ��ʹ��ƴ�ӵķ�ʽ
			ps.setString(1, s);
			// ResultSet�����,���԰�ResultSet���ɷ���һ�ű��еĽ����
			rs = ps.executeQuery();
			if(rs.next())	
			{
				query = true; //��ѯ�ɹ� ����true

				// ��ѧ�����û���������ȡ��
				num = rs.getString(4);
				name = rs.getString(5);
				math = rs.getString(6);
				chinese = rs.getString(7);
				english = rs.getString(8);
				zhengzhi = rs.getString(9);
			}else
			{
				query = false; //��ѯʧ�� ����false
				JOptionPane.showMessageDialog(null, "�]�д�ѧ��������������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			}
	
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void getdatatea(String s) {
		// ���������
		try {
			ps = ct.prepareStatement("select * from info_tea where �̹��� =? ");
			// ��?��ֵ(�ɷ�ֹSQLע��©������)����Ҫֱ��ʹ��ƴ�ӵķ�ʽ
			ps.setString(1, s);
			// ResultSet�����,���԰�ResultSet���ɷ���һ�ű��еĽ����
			rs = ps.executeQuery();
			if(rs.next())	
			{
				query = true;
				// ����ʦ���û���������ȡ��
				teanum = rs.getString(4);
				teaname = rs.getString(5);
				sex = rs.getString(6);
				salary = rs.getString(7);
				zhicheng = rs.getString(8);
				age = rs.getString(9);
			}else
			{
				query = false;
				JOptionPane.showMessageDialog(null, "�]�д˽�ʦ������������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			}
	
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void getnamestu(String s){
		//ͨ���û�����ȡ�û�������ѧ��
		try {
			ps = ct.prepareStatement("select * from info_stu where �û��� =? ");
			// ��?��ֵ(�ɷ�ֹSQLע��©������)����Ҫֱ��ʹ��ƴ�ӵķ�ʽ
			ps.setString(1, s);
			// ResultSet�����,���԰�ResultSet���ɷ���һ�ű��еĽ����
			rs = ps.executeQuery();
			while(rs.next()){
				//����ѧ����������ѧ��ȡ��
				num = rs.getString(4);
				name = rs.getString(5);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void judgenum(String s){
		//ͨ��ѧ���ж��Ƿ���ڸ�ѧ��
		try {
			num=s;//��ѧ�Ÿ���num�����޸ĸ�ѧ���ɼ�
			ps = ct.prepareStatement("select * from info_stu where ѧ�� =? ");
			// ��?��ֵ(�ɷ�ֹSQLע��©������)����Ҫֱ��ʹ��ƴ�ӵķ�ʽ
			ps.setString(1, s);
			// ResultSet�����,���԰�ResultSet���ɷ���һ�ű��еĽ����
			rs = ps.executeQuery();
			if(rs.next()){
				query = true;//ѧ�Ŵ���
			}else
			{
				JOptionPane.showMessageDialog(null, "�]�д�ѧ��������������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
				query = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void setgrade(String math,String chinese,String english,String zhengzhi,String num){
		try {
			ps = ct.prepareStatement("update info_stu set ��ѧ =?, ���� =?, Ӣ�� =?, ���� =? WHERE (ѧ�� =?)");
			ps.setString(1, math);
			ps.setString(2, chinese);
			ps.setString(3, english);
			ps.setString(4, zhengzhi);
			ps.setString(5, num);
			ps.executeUpdate();//�޸�����

			System.out.println("���ݿ���Ϣ���޸�");
			JOptionPane.showMessageDialog(null,"�޸ĳɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ��?��ֵ(�ɷ�ֹSQLע��©������)����Ҫֱ��ʹ��ƴ�ӵķ�ʽ


	}
	
}