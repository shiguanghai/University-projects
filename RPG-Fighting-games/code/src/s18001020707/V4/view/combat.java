package s18001020707.V4.view;

import s18001020707.V4.model.Combat.CombatSystem;
import s18001020707.V4.model.Enemys.Enemy;
import s18001020707.V4.model.People.Role;
import s18001020707.V4.model.Skill.Skill;
import s18001020707.V4.model.Skill.imp.CommonAttack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class combat extends JFrame implements ActionListener {

    JPanel jpRole,jpCombat,jpEnemy,jpCenter,jp1,jp2,jp3,jp4,jp5,jp6,jp7=null;
    //怪物名称 当前hp 最大hp 当前mp  Atk def
    JLabel jlbEname,jlbEcurrentHp,jlbEhp,jlbEmp,jlbEatk,jlbEdef=null;
    //角色名称 当前hp 最大hp 当前mp 最大mp Atk def 经验值 等级 力量 智力 速度 职业 武器 衣服 状态
    JLabel jlbName,jlbCurrentHp,jlbMaxHp,jlbCurrentMP,jlbMaxMp,jlbAtk,jlbDef,jlbExp,jlbLevel,jlbStrength,jlbIntl,jlbSpeed,jlbCareer,jlbWeapon,jlbClothes,jlbState=null;
    //请选择您要使用的攻击：
    JLabel jlbCombat=null;
    //角色攻击
    JButton jbCombat1,jbCombat2,jbCombat3,jbCombat4;
    //角色图像 敌人图像 VS图标
    JLabel jlbRoleImage,jlbEnemyImage,jlbCombatImage=null;

    Role r=null;//角色
    Enemy enemy=null;//怪物
    Skill common=null;//普通攻击
    List<Skill> skills=null;//技能攻击
    int atk = 0;
    CombatSystem combatSystem;

    public combat(Role role, Enemy en){
        r=role;
        enemy=en;
        common = new CommonAttack();
        skills = r.getRoleSkill();

        jbCombat1=new JButton(common.getName());
        jbCombat2=new JButton(skills.get(0).getName());
        jbCombat3=new JButton(skills.get(1).getName());
        jbCombat4=new JButton(skills.get(2).getName());

        jbCombat1.addActionListener(this);
        jbCombat2.addActionListener(this);
        jbCombat3.addActionListener(this);
        jbCombat4.addActionListener(this);

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

        jlbCombatImage = new JLabel();
        jlbCombat = new JLabel("请选择您要使用的攻击：");

        jlbEname = new JLabel("怪物名称："+enemy.getEnemyname()+"  ");
        jlbEcurrentHp = new JLabel("当前hp："+enemy.getHp()+"  ");
        jlbEhp = new JLabel("最大hp："+enemy.getHp()+"  ");
        jlbEmp = new JLabel("Mp："+enemy.getMp()+"  ");
        jlbEatk = new JLabel("Atk："+enemy.getAtk()+"  ");
        jlbEdef = new JLabel("Def："+enemy.getDef()+"  ");
        jlbEnemyImage = new JLabel();

        Icon enemyimage;
        if(enemy.getEnemyname()=="鬼怪妖魔"){
            enemyimage = new ImageIcon("src/s18001020707/V4/view/image/GGYM.png");
        }else if(enemy.getEnemyname()=="歪门邪道"){
            enemyimage = new ImageIcon("src/s18001020707/V4/view/image/WMXD.png");
        }else{
            enemyimage = new ImageIcon("src/s18001020707/V4/view/image/LPZD.png");
        }
        jlbEnemyImage.setIcon(enemyimage);

        Icon combatimaga;
        combatimaga = new ImageIcon("src/s18001020707/V4/view/image/combat.png");
        jlbCombatImage.setIcon(combatimaga);

        jpRole = new JPanel(new GridLayout(4,1));
        jpCombat = new JPanel(new GridLayout(5,1));
        jpEnemy = new JPanel(new GridLayout(4,1));
        jpCenter= new JPanel(new GridBagLayout());
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();
        jp7 = new JPanel();

        //为jpRole布局
        jp1.add(jlbMaxHp);
        jp1.add(jlbCurrentHp);
        jp1.add(jlbMaxMp);
        jp1.add(jlbCurrentMP);

        jp2.add(jlbLevel);
        jp2.add(jlbExp);
        jp2.add(jlbAtk);
        jp2.add(jlbDef);

        jp3.add(jlbStrength);
        jp3.add(jlbIntl);
        jp3.add(jlbSpeed);
        jp3.add(jlbState);

        jp4.add(jlbName);
        jp4.add(jlbCareer);
        jp4.add(jlbWeapon);
        jp4.add(jlbClothes);

        jpRole.add(jp1);
        jpRole.add(jp2);
        jpRole.add(jp3);
        jpRole.add(jp4);

        //为jpCombat布局
        jpCombat.add(jbCombat1);
        jpCombat.add(jbCombat2);
        jpCombat.add(jbCombat3);
        jpCombat.add(jbCombat4);

        //为jpEnemy布局
        jp5.add(jlbEname);

        jp6.add(jlbEcurrentHp);
        jp6.add(jlbEhp);

        jp7.add(jlbEmp);
        jp7.add(jlbEatk);
        jp7.add(jlbEdef);

        jpEnemy.add(jp5);
        jpEnemy.add(jp6);
        jpEnemy.add(jp7);

        //为jpCenter布局
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;//不理睬剩余空间的存在，让它空着

        //角色图像
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=2;
        gbc.gridheight=2;
        gbc.weightx=0.4;
        gbc.weighty=0.3;
        jpCenter.add(jlbRoleImage,gbc);

        //角色属性
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=2;
        gbc.gridheight=1;
        gbc.weightx=0.4;
        gbc.weighty=0.7;
        jpCenter.add(jpRole,gbc);

        //怪物图像
        gbc.gridx=3;
        gbc.gridy=0;
        gbc.gridwidth=2;
        gbc.gridheight=2;
        gbc.weightx=0.4;
        gbc.weighty=0.3;
        jpCenter.add(jlbEnemyImage,gbc);

        //怪物属性
        gbc.gridx=3;
        gbc.gridy=2;
        gbc.gridwidth=2;
        gbc.gridheight=1;
        gbc.weightx=0.4;
        gbc.weighty=0.7;
        jpCenter.add(jpEnemy,gbc);

        //战斗图像
        gbc.gridx=2;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=0.2;
        gbc.weighty=0.15;
        jpCenter.add(jlbCombatImage,gbc);

        //战斗选项
        gbc.gridx=2;
        gbc.gridy=2;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=0.2;
        gbc.weighty=0.7;
        jpCenter.add(jpCombat,gbc);

        this.add(jpCenter);
        //设置布局管理器
        this.setLayout(new GridLayout());
        //给窗口设置标题
        this.setTitle("战斗场景");
        //设置窗体大小
        this.setSize(750,270);
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

        combatSystem = new CombatSystem(enemy,r);
        if(e.getActionCommand()==common.getName()){
            atk = r.attack(common);
        }else if(e.getActionCommand()==skills.get(0).getName()){
            if(r.getCurrentmp()<skills.get(0).getMp()){
                JOptionPane.showMessageDialog(null,"魔法值不足："+r.getCurrentmp()+"/"+skills.get(0).getMp(),"提示消息",JOptionPane.WARNING_MESSAGE);
                atk=0;
            }else {
                atk = r.attack(skills.get(0));
            }
        }else if(e.getActionCommand()==skills.get(1).getName()){
            if(r.getCurrentmp()<skills.get(1).getMp()){
                JOptionPane.showMessageDialog(null,"魔法值不足："+r.getCurrentmp()+"/"+skills.get(1).getMp(),"提示消息",JOptionPane.WARNING_MESSAGE);
                atk=0;
            }else {
                atk = r.attack(skills.get(1));
            }
        }else if(e.getActionCommand()==skills.get(2).getName()){
            if(r.getCurrentmp()<skills.get(2).getMp()){
                JOptionPane.showMessageDialog(null,"魔法值不足："+r.getCurrentmp()+"/"+skills.get(2).getMp(),"提示消息",JOptionPane.WARNING_MESSAGE);
                atk=0;
            }else {
                atk = r.attack(skills.get(2));
            }
        }
        if(atk!=0){//魔法值足够
            int result = combatSystem.roleAttackEnemy(atk);//角色攻击
            if (result == 0){
                r.Victory(enemy.getEnemyname());//怪物死亡 获取怪物名字

                gameStart.jlbCurrentHp.setText("当前hp:"+r.getCurrenthp()+"  ");
                gameStart.jlbMaxHp.setText("最大hp:"+r.getMaxhp()+"  ");
                gameStart.jlbCurrentMP.setText("当前mp:"+r.getCurrentmp()+"  ");
                gameStart.jlbMaxMp.setText("最大mp:"+r.getMp()+"  ");
                gameStart.jlbAtk.setText("Atk:"+r.getAtk()+"  ");
                gameStart.jlbDef.setText("Def:"+r.getDef()+"  ");
                gameStart.jlbExp.setText("经验值:"+r.getExp()+"/"+r.getRoleCareer().useStage(r.getLevel())+"  ");
                gameStart.jlbLevel.setText("等级:"+r.getLevel()+"  ");
                gameStart.jlbStrength.setText("力量:"+r.getStrength()+"  ");
                gameStart.jlbIntl.setText("智力:"+r.getIntl()+"  ");
                gameStart.jlbSpeed.setText("速度:"+r.getSpeed()+"  ");

                dispose();
            }else {
                jlbEcurrentHp.setText("当前hp："+enemy.getHp()+"  ");//怪物存活，更新怪物属性
                JOptionPane.showMessageDialog(null,"怪物剩余生命:"+enemy.getHp(),"提示消息",JOptionPane.WARNING_MESSAGE);
                JOptionPane.showMessageDialog(null,"怪物对您进行攻击！","提示消息",JOptionPane.WARNING_MESSAGE);
                int ss = combatSystem.EnemyAttackRole(enemy.Attack());//怪物攻击 并获取角色剩余血量
                jlbCurrentHp.setText("当前hp:"+r.getCurrenthp()+"  ");
                r.updateState();//更新角色战斗状态
                //角色战斗状态获取
                if(r.getState().toString()=="濒死"&& ss != 0)
                {
                    JOptionPane.showMessageDialog(null,"您的个人状态："+r.getState()+", 您将获得50%的攻击力加成","提示消息",JOptionPane.WARNING_MESSAGE);
                }
                else if(r.getState().toString()=="健康"&& ss != 0){
                    JOptionPane.showMessageDialog(null,"您的个人状态："+r.getState(),"提示消息",JOptionPane.WARNING_MESSAGE);
                }
                if (ss == 0) {
                    System.exit(0);
                }
            }
        }

    }
}
