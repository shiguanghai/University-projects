package s18001020707.V4.view;


import s18001020707.V4.model.Enemys.CloneEnemy;
import s18001020707.V4.model.Enemys.Enemy;
import s18001020707.V4.model.Equipment.Clothes.imp.freshClothes;
import s18001020707.V4.model.Equipment.Clothes.imp.superiorClothes;
import s18001020707.V4.model.Equipment.Weapon.imp.EM_Chi;
import s18001020707.V4.model.Equipment.Weapon.imp.SL_gun;
import s18001020707.V4.model.Equipment.Weapon.imp.TM_Biao;
import s18001020707.V4.model.Equipment.Weapon.imp.freshWeapon;
import s18001020707.V4.model.People.Role;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class gameStart extends JFrame implements ActionListener {

    //�������
    JPanel jpAttribute,jpButton,jpCenter,jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8,jp9=null;
    //������ ��������װ�� �������ַ��� ������������ �������ɷ��� �������� ��������Ƥ��
    JButton jbFight,jbSetFreshWeapon,jbSetFreshClothes,jbSetRoleWeapon,jbSetRoleClothes,jbWeaponLevelup,jbWeaponSkin=null;
    //��ɫ���� ��ǰhp ���hp ��ǰmp ���mp Atk def ����ֵ �ȼ� ���� ���� �ٶ� ְҵ ���� �·� ���� ״̬
    public static JLabel jlbName,jlbCurrentHp,jlbMaxHp,jlbCurrentMP,jlbMaxMp,jlbAtk,jlbDef,jlbExp,jlbLevel,jlbStrength,jlbIntl,jlbSpeed,jlbCareer,jlbWeapon,jlbClothes,jlbSkill,jlbState=null;
    //��ɫͼ��
    JLabel jlbRoleImage=null;

    //�˵���
    JMenuBar jmb=null;
    JMenu jm=null;
    JMenuItem jmiQuit=null;

    private Role r=null;//��ɫ
    private Enemy enemy=null;//����

    public gameStart(Role role){
        r=role;//����Ҫ��
        //�������
        jbFight=new JButton("������");
        jbSetFreshWeapon=new JButton("��������װ��");
        jbSetFreshClothes=new JButton("�������ַ���");
        jbSetRoleWeapon=new JButton("������������");
        jbSetRoleClothes=new JButton("�������ɷ���");
        jbWeaponLevelup=new JButton("������������");
        jbWeaponSkin=new JButton("��������Ƥ��");
        //���ü���
        jbFight.addActionListener(this);
        jbSetFreshWeapon.addActionListener(this);
        jbSetFreshClothes.addActionListener(this);
        jbSetRoleWeapon.addActionListener(this);
        jbSetRoleClothes.addActionListener(this);
        jbWeaponLevelup .addActionListener(this);
        jbWeaponSkin.addActionListener(this);

        jmb=new JMenuBar();//JMenuBarָ�˵���
        jm=new JMenu("ѡ��");//JMenu�ǲ˵����е�ѡ����
        jmiQuit=new JMenuItem("�˳���Ϸ");//JMenuIItemָѡ�����е�ѡ��
        jm.add(jmiQuit);
        jmb.add(jm);
        //���ü���
        jmiQuit.addActionListener(this);

        jlbName=new JLabel("��ɫ����:"+r.getRolename()+"  ");
        jlbCurrentHp=new JLabel("��ǰhp:"+r.getCurrenthp()+"  ");
        jlbMaxHp=new JLabel("���hp:"+r.getMaxhp()+"  ");
        jlbCurrentMP=new JLabel("��ǰmp:"+r.getCurrentmp()+"  ");
        jlbMaxMp=new JLabel("���mp:"+r.getMp()+"  ");
        jlbAtk=new JLabel("Atk:"+r.getAtk()+"  ");
        jlbDef=new JLabel("Def:"+r.getDef()+"  ");
        jlbExp=new JLabel("����ֵ:"+r.getExp()+"/"+r.getRoleCareer().useStage(r.getLevel())+"  ");
        jlbLevel=new JLabel("�ȼ�:"+r.getLevel()+"  ");
        jlbStrength=new JLabel("����:"+r.getStrength()+"  ");
        jlbIntl=new JLabel("����:"+r.getIntl()+"  ");
        jlbSpeed=new JLabel("�ٶ�:"+r.getSpeed()+"  ");
        jlbCareer=new JLabel("ְҵ:"+r.getRoleCareer()+"  ");
        jlbWeapon=new JLabel("����:"+r.getRoleWeapon()+"  ");
        jlbClothes=new JLabel("�·�:"+r.getRoleClothes()+"  ");
        jlbSkill=new JLabel("����:"+r.getRoleSkill());
        jlbState=new JLabel("״̬:"+r.getState()+"  ");
        jlbRoleImage=new JLabel();

        Icon roleimage;
        if(r.getRoleCareer().toString()=="������"){
            roleimage = new ImageIcon("src/s18001020707/V4/view/image/SL.png");
        }else if(r.getRoleCareer().toString()=="��ü��"){
            roleimage = new ImageIcon("src/s18001020707/V4/view/image/EM.png");
        }else{
            roleimage = new ImageIcon("src/s18001020707/V4/view/image/TM.png");
        }
        jlbRoleImage.setIcon(roleimage);

        jpAttribute=new JPanel(new GridLayout(5,1));
        jpButton= new JPanel(new GridLayout(4,1));
        jpCenter= new JPanel(new GridBagLayout());
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();
        jp7 = new JPanel();
        jp8 = new JPanel();
        jp9 = new JPanel();

        //ΪjpAttribute����
        jp5.add(jlbMaxHp);
        jp5.add(jlbCurrentHp);
        jp5.add(jlbMaxMp);
        jp5.add(jlbCurrentMP);

        jp6.add(jlbLevel);
        jp6.add(jlbExp);
        jp6.add(jlbAtk);
        jp6.add(jlbDef);

        jp7.add(jlbStrength);
        jp7.add(jlbIntl);
        jp7.add(jlbSpeed);
        jp7.add(jlbState);

        jp8.add(jlbName);
        jp8.add(jlbCareer);
        jp8.add(jlbWeapon);
        jp8.add(jlbClothes);

        jp9.add(jlbSkill);

        jpAttribute.add(jp5);
        jpAttribute.add(jp6);
        jpAttribute.add(jp7);
        jpAttribute.add(jp8);
        jpAttribute.add(jp9);

        //ΪjpButton����
        jp1.add(jbSetFreshWeapon);
        jp1.add(jbSetFreshClothes);

        jp2.add(jbSetRoleWeapon);
        jp2.add(jbSetRoleClothes);

        jp3.add(jbWeaponSkin);
        jp3.add(jbWeaponLevelup);

        jp4.add(jbFight);

        jpButton.add(jp1);
        jpButton.add(jp2);
        jpButton.add(jp3);
        jpButton.add(jp4);


        //ΪjpCenter����
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;//�����ʣ��ռ�Ĵ��ڣ���������

        //��ɫͼ��
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=2;
        gbc.gridheight=2;
        gbc.weightx=0.5;
        gbc.weighty=0.3;
        jpCenter.add(jlbRoleImage,gbc);

        //��ɫ����(����������)
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=2;
        gbc.gridheight=1;
        gbc.weightx=0.5;
        gbc.weighty=0.7;
        jpCenter.add(jpAttribute,gbc);


        //��ɫ����
        gbc.gridx=2;
        gbc.gridy=0;
        gbc.gridwidth=1;
        gbc.gridheight=3;
        gbc.weightx=0.5;
        gbc.weighty=1;
        jpCenter.add(jpButton,gbc);

        //����JFrame��
        this.setJMenuBar(jmb);//ѡ��
        this.add(jpCenter);
        //���ò��ֹ�����
        this.setLayout(new GridLayout());
        //���������ñ���
        this.setTitle("��Ϸս��ϵͳ(RPGС��Ϸ)");
        //���ô����С
        this.setSize(630,300);
        //���ô����ʼλ��
        this.setLocationRelativeTo(null);
        //���õ��رմ���ʱ����֤JVMҲ�˳�
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //��ʾ����
        this.setVisible(true);
        this.setResizable(false);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cpmmand = e.getActionCommand();
        switch (cpmmand){
            case "�˳���Ϸ":
                System.exit(0);
                break;
            case "��������װ��":
                freshWeapon fw=new freshWeapon();
                r.setRoleWeapon(fw);
                jlbWeapon.setText("����:"+r.getRoleWeapon()+"  ");
                JOptionPane.showMessageDialog(null,"�����ɹ�,��ǰ����"+r.getRoleWeapon().toString()+"����ǰ����������"+r.getRoleWeapon().getAtk(),"��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
                break;
            case "�������ַ���":
                r.setRoleClothes(new freshClothes());
                jlbClothes.setText("�·�:"+r.getRoleClothes()+"  ");
                JOptionPane.showMessageDialog(null,"�����ɹ�,��ǰ����"+r.getRoleClothes().toString()+"����ǰ���߷�����"+r.getRoleClothes().getDef(),"��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
                break;
            case "������������":
                if (r.getRoleCareer().toString().equals("������")){
                    r.setRoleWeapon(new SL_gun());
                    jlbWeapon.setText("����:"+r.getRoleWeapon()+"  ");
                }
                if (r.getRoleCareer().toString().equals("��ü��")){
                    r.setRoleWeapon(new EM_Chi());
                    jlbWeapon.setText("����:"+r.getRoleWeapon()+"  ");
                }
                if (r.getRoleCareer().toString().equals("����")){
                    r.setRoleWeapon(new TM_Biao());
                    jlbWeapon.setText("����:"+r.getRoleWeapon()+"  ");
                }
                JOptionPane.showMessageDialog(null,"�����ɹ�,��ǰ����"+r.getRoleWeapon().toString()+"����ǰ����������"+r.getRoleWeapon().getAtk(),"��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
                break;
            case "�������ɷ���":
                r.setRoleClothes(new superiorClothes());
                jlbClothes.setText("�·�:"+r.getRoleClothes()+"  ");
                JOptionPane.showMessageDialog(null,"�����ɹ�,��ǰ����"+r.getRoleClothes().toString()+"����ǰ���߷�����"+r.getRoleClothes().getDef(),"��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
                break;
            case "��������Ƥ��":
                changeSkin changeSkin = new changeSkin(r);
                changeSkin.setVisible(true);
                break;
            case "������������":
                r.getRoleWeapon().levelup();
                JOptionPane.showMessageDialog(null,"����ɹ�����ǰ����������"+r.getRoleWeapon().getAtk(),"��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
                break;
            case "������":
                CloneEnemy cloneEnemy = new CloneEnemy();
                Random random = new Random();
                int ene = random.nextInt(100);
                try {
                    if (ene > 80) {
                        enemy = cloneEnemy.getEnemyclone("�����ħ");

                    } else if (ene > 50) {
                        enemy = cloneEnemy.getEnemyclone("����а��");

                    } else {
                        enemy = cloneEnemy.getEnemyclone("�����ӵ�");

                    }
                    JOptionPane.showMessageDialog(null,"����"+enemy.getEnemyname()+"���٣�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);


                } catch (NoSuchMethodException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                } catch (InstantiationException ex) {
                    ex.printStackTrace();
                } catch (InvocationTargetException ex) {
                    ex.printStackTrace();
                }

                fight f=new fight(r,enemy);
                f.setVisible(true);

        }
    }

}
