package s18001020707.V4.view;

import s18001020707.V4.model.Enemys.Enemy;
import s18001020707.V4.model.People.Role;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fight extends JFrame implements ActionListener {

    //�������
    JButton jb1 = null;//ȷ��
    JRadioButton jrb1,jrb2,jrb3=null;//���� ���� �������
    ButtonGroup bg=null;//�ж���
    JLabel jlb1,jlb2=null;//������Ϣ  ��ѡ�������ж���
    JPanel jp1,jp2,jp3=null;

    Role r=null;
    Enemy en=null;

    public fight(Role role,Enemy enemy){
        r=role;
        en=enemy;

        jb1=new JButton("ȷ��");
        jb1.addActionListener(this);

        jrb1=new JRadioButton("����",true);
        jrb2=new JRadioButton("����");
        jrb3=new JRadioButton("�������");
        bg=new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);

        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();

        jlb1=new JLabel(en.toString());
        jlb2=new JLabel("��ѡ�������ж�");

        jp1.add(jlb1);

        jp2.add(jlb2);
        jp2.add(jrb1);
        jp2.add(jrb2);
        jp2.add(jrb3);

        jp3.add(jb1);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.setLayout(new GridLayout(3,1));
        //���������ñ���
        this.setTitle("�ж�ѡ��");
        //���ô����С
        this.setSize(360,150);
        //���ô����ʼλ��
        this.setLocationRelativeTo(null);
        //��ʾ����
        this.setVisible(true);
        this.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="ȷ��"){
            if(jrb1.isSelected()){
                //����
                combat c = new combat(r,en);
                c.setVisible(true);
                dispose();

            }else if(jrb2.isSelected()){
                //����
                JOptionPane.showMessageDialog(null,"�㷵���˳���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
                dispose();

            }else if(jrb3.isSelected()){
                //�������
                JOptionPane.showMessageDialog(null,"����������Ķ�����ɱ�����㣡��Ϸ������","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
                System.exit(0);

            }
        }

    }

}
