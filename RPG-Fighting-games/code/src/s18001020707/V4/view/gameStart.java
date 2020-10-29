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

    //定义组件
    JPanel jpAttribute,jpButton,jpCenter,jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8,jp9=null;
    //外出逛逛 更换新手装备 更换新手防具 更换门派武器 更换门派防具 锻造武器 更换武器皮肤
    JButton jbFight,jbSetFreshWeapon,jbSetFreshClothes,jbSetRoleWeapon,jbSetRoleClothes,jbWeaponLevelup,jbWeaponSkin=null;
    //角色名称 当前hp 最大hp 当前mp 最大mp Atk def 经验值 等级 力量 智力 速度 职业 武器 衣服 技能 状态
    public static JLabel jlbName,jlbCurrentHp,jlbMaxHp,jlbCurrentMP,jlbMaxMp,jlbAtk,jlbDef,jlbExp,jlbLevel,jlbStrength,jlbIntl,jlbSpeed,jlbCareer,jlbWeapon,jlbClothes,jlbSkill,jlbState=null;
    //角色图像
    JLabel jlbRoleImage=null;

    //菜单项
    JMenuBar jmb=null;
    JMenu jm=null;
    JMenuItem jmiQuit=null;

    private Role r=null;//角色
    private Enemy enemy=null;//怪物

    public gameStart(Role role){
        r=role;//很重要！
        //创建组件
        jbFight=new JButton("外出逛逛");
        jbSetFreshWeapon=new JButton("更换新手装备");
        jbSetFreshClothes=new JButton("更换新手防具");
        jbSetRoleWeapon=new JButton("更换门派武器");
        jbSetRoleClothes=new JButton("更换门派防具");
        jbWeaponLevelup=new JButton("锻造武器攻击");
        jbWeaponSkin=new JButton("更换武器皮肤");
        //设置监听
        jbFight.addActionListener(this);
        jbSetFreshWeapon.addActionListener(this);
        jbSetFreshClothes.addActionListener(this);
        jbSetRoleWeapon.addActionListener(this);
        jbSetRoleClothes.addActionListener(this);
        jbWeaponLevelup .addActionListener(this);
        jbWeaponSkin.addActionListener(this);

        jmb=new JMenuBar();//JMenuBar指菜单栏
        jm=new JMenu("选项");//JMenu是菜单栏中的选项栏
        jmiQuit=new JMenuItem("退出游戏");//JMenuIItem指选项栏中的选项
        jm.add(jmiQuit);
        jmb.add(jm);
        //设置监听
        jmiQuit.addActionListener(this);

        jlbName=new JLabel("角色名称:"+r.getRolename()+"  ");
        jlbCurrentHp=new JLabel("当前hp:"+r.getCurrenthp()+"  ");
        jlbMaxHp=new JLabel("最大hp:"+r.getMaxhp()+"  ");
        jlbCurrentMP=new JLabel("当前mp:"+r.getCurrentmp()+"  ");
        jlbMaxMp=new JLabel("最大mp:"+r.getMp()+"  ");
        jlbAtk=new JLabel("Atk:"+r.getAtk()+"  ");
        jlbDef=new JLabel("Def:"+r.getDef()+"  ");
        jlbExp=new JLabel("经验值:"+r.getExp()+"/"+r.getRoleCareer().useStage(r.getLevel())+"  ");
        jlbLevel=new JLabel("等级:"+r.getLevel()+"  ");
        jlbStrength=new JLabel("力量:"+r.getStrength()+"  ");
        jlbIntl=new JLabel("智力:"+r.getIntl()+"  ");
        jlbSpeed=new JLabel("速度:"+r.getSpeed()+"  ");
        jlbCareer=new JLabel("职业:"+r.getRoleCareer()+"  ");
        jlbWeapon=new JLabel("武器:"+r.getRoleWeapon()+"  ");
        jlbClothes=new JLabel("衣服:"+r.getRoleClothes()+"  ");
        jlbSkill=new JLabel("技能:"+r.getRoleSkill());
        jlbState=new JLabel("状态:"+r.getState()+"  ");
        jlbRoleImage=new JLabel();

        Icon roleimage;
        if(r.getRoleCareer().toString()=="少林派"){
            roleimage = new ImageIcon("src/s18001020707/V4/view/image/SL.png");
        }else if(r.getRoleCareer().toString()=="峨眉派"){
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

        //为jpAttribute布局
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

        //为jpButton布局
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


        //为jpCenter布局
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;//不理睬剩余空间的存在，让它空着

        //角色图像
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=2;
        gbc.gridheight=2;
        gbc.weightx=0.5;
        gbc.weighty=0.3;
        jpCenter.add(jlbRoleImage,gbc);

        //角色属性(不包含技能)
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=2;
        gbc.gridheight=1;
        gbc.weightx=0.5;
        gbc.weighty=0.7;
        jpCenter.add(jpAttribute,gbc);


        //角色动作
        gbc.gridx=2;
        gbc.gridy=0;
        gbc.gridwidth=1;
        gbc.gridheight=3;
        gbc.weightx=0.5;
        gbc.weighty=1;
        jpCenter.add(jpButton,gbc);

        //加入JFrame中
        this.setJMenuBar(jmb);//选项
        this.add(jpCenter);
        //设置布局管理器
        this.setLayout(new GridLayout());
        //给窗口设置标题
        this.setTitle("游戏战斗系统(RPG小游戏)");
        //设置窗体大小
        this.setSize(630,300);
        //设置窗体初始位置
        this.setLocationRelativeTo(null);
        //设置当关闭窗口时，保证JVM也退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //显示窗体
        this.setVisible(true);
        this.setResizable(false);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cpmmand = e.getActionCommand();
        switch (cpmmand){
            case "退出游戏":
                System.exit(0);
                break;
            case "更换新手装备":
                freshWeapon fw=new freshWeapon();
                r.setRoleWeapon(fw);
                jlbWeapon.setText("武器:"+r.getRoleWeapon()+"  ");
                JOptionPane.showMessageDialog(null,"更换成功,当前武器"+r.getRoleWeapon().toString()+"，当前武器攻击力"+r.getRoleWeapon().getAtk(),"提示消息",JOptionPane.WARNING_MESSAGE);
                break;
            case "更换新手防具":
                r.setRoleClothes(new freshClothes());
                jlbClothes.setText("衣服:"+r.getRoleClothes()+"  ");
                JOptionPane.showMessageDialog(null,"更换成功,当前防具"+r.getRoleClothes().toString()+"，当前防具防御力"+r.getRoleClothes().getDef(),"提示消息",JOptionPane.WARNING_MESSAGE);
                break;
            case "更换门派武器":
                if (r.getRoleCareer().toString().equals("少林派")){
                    r.setRoleWeapon(new SL_gun());
                    jlbWeapon.setText("武器:"+r.getRoleWeapon()+"  ");
                }
                if (r.getRoleCareer().toString().equals("峨眉派")){
                    r.setRoleWeapon(new EM_Chi());
                    jlbWeapon.setText("武器:"+r.getRoleWeapon()+"  ");
                }
                if (r.getRoleCareer().toString().equals("唐门")){
                    r.setRoleWeapon(new TM_Biao());
                    jlbWeapon.setText("武器:"+r.getRoleWeapon()+"  ");
                }
                JOptionPane.showMessageDialog(null,"更换成功,当前武器"+r.getRoleWeapon().toString()+"，当前武器攻击力"+r.getRoleWeapon().getAtk(),"提示消息",JOptionPane.WARNING_MESSAGE);
                break;
            case "更换门派防具":
                r.setRoleClothes(new superiorClothes());
                jlbClothes.setText("衣服:"+r.getRoleClothes()+"  ");
                JOptionPane.showMessageDialog(null,"更换成功,当前防具"+r.getRoleClothes().toString()+"，当前防具防御力"+r.getRoleClothes().getDef(),"提示消息",JOptionPane.WARNING_MESSAGE);
                break;
            case "更换武器皮肤":
                changeSkin changeSkin = new changeSkin(r);
                changeSkin.setVisible(true);
                break;
            case "锻造武器攻击":
                r.getRoleWeapon().levelup();
                JOptionPane.showMessageDialog(null,"锻造成功，当前武器攻击力"+r.getRoleWeapon().getAtk(),"提示消息",JOptionPane.WARNING_MESSAGE);
                break;
            case "外出逛逛":
                CloneEnemy cloneEnemy = new CloneEnemy();
                Random random = new Random();
                int ene = random.nextInt(100);
                try {
                    if (ene > 80) {
                        enemy = cloneEnemy.getEnemyclone("鬼怪妖魔");

                    } else if (ene > 50) {
                        enemy = cloneEnemy.getEnemyclone("歪门邪道");

                    } else {
                        enemy = cloneEnemy.getEnemyclone("落魄子弟");

                    }
                    JOptionPane.showMessageDialog(null,"遭遇"+enemy.getEnemyname()+"抢劫！","提示消息",JOptionPane.WARNING_MESSAGE);


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
