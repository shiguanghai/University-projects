/*
 * ���ܣ�ѧ���ɼ�����ϵͳ
 * ����1����¼����ľ�̬ʵ��
 * ����2��ʵ�ֽ�����л�
 * ����3��ʹ�����ݿ�����֤�û���������
 * ����4���Դ�������Ż�������ר�����������ݿ�������ӵ���
 * ����5���Ż����룬�����ж�������
 * ����6��ʹ�����ݿ���в�ѯʱ���Ż���ѯ�������ж����������ݿ�ı��п��ж�����ݡ����벻ͬ�ı�����ѯ��
 * ����7����ʦ����ʵ���˲�ѯĳ��ѧ����Ϣ��ĳ��ʦ��Ϣ�Ĺ����Լ��޸�ѧ���ɼ���
 * ����8��ѧ������ʵ����ʾ��ǰ��¼�û���Ϣ����ѯ����
 * ����9���Ż�UI���棬����֤������ȶ�����
 */
package com.package_7;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

	//�����¼��������
	JButton jb1,jb2,jb3=null;//��¼ ���� �˳� ����ť
	JRadioButton jrb1,jrb2=null;//��ʦ ѧ�� ��ѡ��
	JPanel jp1,jp2,jp3,jp4=null;//����
    JTextField jtf=null;//�û��������
	JLabel jlb1,jlb2,jlb3=null;//�û��� ���� Ȩ�ޣ���ʾ
	JPasswordField jpf=null;//���������
	ButtonGroup bg=null;//��ʦѧ����
	
	//�˵���
	JMenuBar jmb=null;	
	JMenu jm=null;
	JMenuItem jmi1,jmi2=null;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login ms=new Login();
		
						
	}
	//���캯��
	public Login()
	{
		 //�������
		jb1=new JButton("��¼");
		jb2=new JButton("����");
		jb3=new JButton("�˳�");
		//���ü���
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		
		jmb=new JMenuBar(); //JMenuBarָ�˵���
		jm=new JMenu("ѡ��"); //JMenu�ǲ˵����е�ѡ����
		jmi1=new JMenuItem("��ʼ"); //JMenuItemָѡ�����е�ѡ��
		jmi2=new JMenuItem("�˳�ϵͳ");
		jm.add(jmi1);
		jm.add(jmi2);
		jmb.add(jm);
		
		
		jrb1=new JRadioButton("��ʦ",true);
		jrb2=new JRadioButton("ѧ��");
		bg=new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
//		jrb2.setSelected(true);
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();				
		
		jlb1=new JLabel("�û�����");
		jlb2=new JLabel("��    �룺");
		jlb3=new JLabel("Ȩ    �ޣ�");
		
		jtf=new JTextField(10);
		jpf=new JPasswordField(10);
		//���뵽JPanel��
		jp1.add(jlb1);
		jp1.add(jtf);
		
		jp2.add(jlb2);
		jp2.add(jpf);
		
		jp3.add(jlb3);
		jp3.add(jrb1);
		jp3.add(jrb2);
		
		jp4.add(jb1);
		jp4.add(jb2);
		jp4.add(jb3);
		
		//����JFrame��
		this.setJMenuBar(jmb);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		//���ò��ֹ�����
		this.setLayout(new GridLayout(4,1));
		//���������ñ���
		this.setTitle("ѧ���ɼ�����ϵͳ");
		//���ô����С
		this.setSize(300,250);
		//���ô����ʼλ��
		this.setLocationRelativeTo(null);
		//���õ��رմ���ʱ����֤JVMҲ�˳�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//��ʾ����
		this.setVisible(true);
		this.setResizable(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand()=="�˳�")
		{
			System.exit(0);
		}else if(e.getActionCommand()=="��¼")
		{
			//���ж��û�����������Ƿ����Ԫ���еĻ� isEmpty����false
			if(!jtf.getText().isEmpty() && !jpf.getText().isEmpty())
			{
				//�������¼��ťʱ�����������ݿ⽨������
				GetSQL.ConnectSQL();
				//���ѡ�н�ʦ��¼
				if(jrb1.isSelected())
				{
					GetSQL.querytea("��ʦ",jtf.getText());
					//�����ж��Ƿ���ڸ��û������Ƿ�õ�������
					if(GetSQL.pwd ==null)
					{
                         this.clear();
					}else
					{
						//���õ�¼����
						this.tealogin();
					}
				}else if(jrb2.isSelected()) //ѧ���ڵ�¼ϵͳ
				{
					GetSQL.querystu("ѧ��",jtf.getText());
					//�����ж��Ƿ���ڸ��û������Ƿ�õ�������
					if(GetSQL.pwd ==null)
					{
                         this.clear();
					}else
					{
						//���õ�¼����
						this.stulogin();
					}
				   
				}
			}else if(jtf.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"�������û���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
			    this.clear();
			}else if(jpf.getText().isEmpty())	
			{
				JOptionPane.showMessageDialog(null,"����������","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
			    this.clear();
			}
		}else if(e.getActionCommand()=="����")
		{
			this.clear();
		}			
		
	}
				
		//����ı���������
	public	void clear()
		{
			jtf.setText("");
			jpf.setText("");
		}
		    //ѧ����¼�жϷ���
			public void stulogin()
			{
				if(GetSQL.pwd.equals(jpf.getText()))
				{
//					System.out.println("��¼�ɹ�");
					JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
					this.clear();
					//�رյ�ǰ����
					 dispose();
					 //����һ���½���
					 Student ui=new Student();
				}else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"�������û��������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if(jtf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"�������û�����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if(jpf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"���������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else
				{
					JOptionPane.showMessageDialog(null,"�û��������������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
				    //��������
					this.clear();
				}
			}
			
			//��ʦ��¼�жϷ���
			public void tealogin()
			{
				if(GetSQL.pwd.equals(jpf.getText()))
				{
//					System.out.println("��¼�ɹ�");
					 JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
					 this.clear();	
					//�رյ�ǰ����
					 dispose();
					 //����һ���½��棬�����ڽ�ʦ������ѧ��
					Teacher t=new Teacher();
				}else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"�������û��������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if(jtf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"�������û�����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if(jpf.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"���������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else
				{
					JOptionPane.showMessageDialog(null,"�û��������������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
				    //��������
					this.clear();
				}
			}
		
}






	
