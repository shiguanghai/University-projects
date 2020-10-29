package s18001020707.V4.view;

import s18001020707.V4.model.Equipment.Weapon.imp.EM_Chi;
import s18001020707.V4.model.Equipment.Weapon.imp.SL_gun;
import s18001020707.V4.model.Equipment.Weapon.imp.TM_Biao;
import s18001020707.V4.model.Equipment.Weapon.skin.DazzlingSkin;
import s18001020707.V4.model.Equipment.Weapon.skin.DivineSkin;
import s18001020707.V4.model.People.Role;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changeSkin extends JFrame implements ActionListener {
    //�������
    JButton jb1 = null;//����
    JRadioButton jrb1,jrb2,jrb3=null;//�� �Ų�Ƥ��(Lv2) ��Ƥ��(Lv5)
    ButtonGroup bg=null;//Ƥ����
    JLabel jlb1=null;//��Ҫ������Ƥ����
    JPanel jp1,jp2=null;

    Role r=null;

    public changeSkin(Role role){
        r=role;
        jb1=new JButton("����");
        jb1.addActionListener(this);

        jrb1=new JRadioButton("��",true);
        jrb2=new JRadioButton("�Ų�Ƥ��(Lv2)");
        jrb3=new JRadioButton("��Ƥ��(Lv5)");
        bg=new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);

        jp1=new JPanel();
        jp2=new JPanel();

        jlb1=new JLabel("��Ҫ������Ƥ����");

        jp1.add(jlb1);
        jp1.add(jrb1);
        jp1.add(jrb2);
        jp1.add(jrb3);

        jp2.add(jb1);

        this.add(jp1);
        this.add(jp2);

        this.setLayout(new GridLayout(2,1));
        //���������ñ���
        this.setTitle("����Ƥ������");
        //���ô����С
        this.setSize(400,100);
        //���ô����ʼλ��
        this.setLocationRelativeTo(null);
        //��ʾ����
        this.setVisible(true);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="����"){
            if(jrb1.isSelected()){
                //��
                if(r.getRoleCareer().toString().equals("������")){
                    r.setRoleWeapon(new SL_gun());
                }else if(r.getRoleCareer().toString().equals("��ü��")){
                    r.setRoleWeapon(new EM_Chi());
                }else if(r.getRoleCareer().toString().equals("����")){
                    r.setRoleWeapon(new TM_Biao());
                }
                gameStart.jlbWeapon.setText("����:"+r.getRoleWeapon()+"  ");
                JOptionPane.showMessageDialog(null,"�����ɹ�,��ǰ����"+r.getRoleWeapon().toString()+"����ǰ����������"+r.getRoleWeapon().getAtk(),"��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
            }else if(jrb2.isSelected()){
                //�Ų�
                if(r.getLevel()>=2){
                    if(r.getRoleCareer().toString().equals("������")){
                        r.setRoleWeapon(new DazzlingSkin(new SL_gun()));
                    }else if(r.getRoleCareer().toString().equals("��ü��")){
                        r.setRoleWeapon(new DazzlingSkin(new EM_Chi()));
                    }else if(r.getRoleCareer().toString().equals("����")){
                        r.setRoleWeapon(new DivineSkin(new EM_Chi()));
                    }
                    gameStart.jlbWeapon.setText("����:"+r.getRoleWeapon()+"  ");
                    JOptionPane.showMessageDialog(null,"�����ɹ�,��ǰ����"+r.getRoleWeapon().toString()+"����ǰ����������"+r.getRoleWeapon().getAtk(),"��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null,"�ȼ�δ�ﵽ","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
                    dispose();
                }

            }else if(jrb3.isSelected()){
                //��
                if(r.getLevel()>=5){
                    if(r.getRoleCareer().toString().equals("������")){
                        r.setRoleWeapon(new DivineSkin(new SL_gun()));
                    }else if(r.getRoleCareer().toString().equals("��ü��")){
                        r.setRoleWeapon(new DivineSkin(new EM_Chi()));
                    }else if(r.getRoleCareer().toString().equals("����")){
                        r.setRoleWeapon(new DivineSkin(new TM_Biao()));
                    }
                    gameStart.jlbWeapon.setText("����:"+r.getRoleWeapon()+"  ");
                    JOptionPane.showMessageDialog(null,"�����ɹ�,��ǰ����"+r.getRoleWeapon().toString()+"����ǰ����������"+r.getRoleWeapon().getAtk(),"��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null,"�ȼ�δ�ﵽ","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
                    dispose();
                }
            }
            dispose();
        }
    }
}
