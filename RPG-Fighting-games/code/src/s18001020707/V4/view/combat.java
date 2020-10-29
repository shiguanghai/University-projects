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
    //�������� ��ǰhp ���hp ��ǰmp  Atk def
    JLabel jlbEname,jlbEcurrentHp,jlbEhp,jlbEmp,jlbEatk,jlbEdef=null;
    //��ɫ���� ��ǰhp ���hp ��ǰmp ���mp Atk def ����ֵ �ȼ� ���� ���� �ٶ� ְҵ ���� �·� ״̬
    JLabel jlbName,jlbCurrentHp,jlbMaxHp,jlbCurrentMP,jlbMaxMp,jlbAtk,jlbDef,jlbExp,jlbLevel,jlbStrength,jlbIntl,jlbSpeed,jlbCareer,jlbWeapon,jlbClothes,jlbState=null;
    //��ѡ����Ҫʹ�õĹ�����
    JLabel jlbCombat=null;
    //��ɫ����
    JButton jbCombat1,jbCombat2,jbCombat3,jbCombat4;
    //��ɫͼ�� ����ͼ�� VSͼ��
    JLabel jlbRoleImage,jlbEnemyImage,jlbCombatImage=null;

    Role r=null;//��ɫ
    Enemy enemy=null;//����
    Skill common=null;//��ͨ����
    List<Skill> skills=null;//���ܹ���
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

        jlbCombatImage = new JLabel();
        jlbCombat = new JLabel("��ѡ����Ҫʹ�õĹ�����");

        jlbEname = new JLabel("�������ƣ�"+enemy.getEnemyname()+"  ");
        jlbEcurrentHp = new JLabel("��ǰhp��"+enemy.getHp()+"  ");
        jlbEhp = new JLabel("���hp��"+enemy.getHp()+"  ");
        jlbEmp = new JLabel("Mp��"+enemy.getMp()+"  ");
        jlbEatk = new JLabel("Atk��"+enemy.getAtk()+"  ");
        jlbEdef = new JLabel("Def��"+enemy.getDef()+"  ");
        jlbEnemyImage = new JLabel();

        Icon enemyimage;
        if(enemy.getEnemyname()=="�����ħ"){
            enemyimage = new ImageIcon("src/s18001020707/V4/view/image/GGYM.png");
        }else if(enemy.getEnemyname()=="����а��"){
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

        //ΪjpRole����
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

        //ΪjpCombat����
        jpCombat.add(jbCombat1);
        jpCombat.add(jbCombat2);
        jpCombat.add(jbCombat3);
        jpCombat.add(jbCombat4);

        //ΪjpEnemy����
        jp5.add(jlbEname);

        jp6.add(jlbEcurrentHp);
        jp6.add(jlbEhp);

        jp7.add(jlbEmp);
        jp7.add(jlbEatk);
        jp7.add(jlbEdef);

        jpEnemy.add(jp5);
        jpEnemy.add(jp6);
        jpEnemy.add(jp7);

        //ΪjpCenter����
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;//�����ʣ��ռ�Ĵ��ڣ���������

        //��ɫͼ��
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=2;
        gbc.gridheight=2;
        gbc.weightx=0.4;
        gbc.weighty=0.3;
        jpCenter.add(jlbRoleImage,gbc);

        //��ɫ����
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=2;
        gbc.gridheight=1;
        gbc.weightx=0.4;
        gbc.weighty=0.7;
        jpCenter.add(jpRole,gbc);

        //����ͼ��
        gbc.gridx=3;
        gbc.gridy=0;
        gbc.gridwidth=2;
        gbc.gridheight=2;
        gbc.weightx=0.4;
        gbc.weighty=0.3;
        jpCenter.add(jlbEnemyImage,gbc);

        //��������
        gbc.gridx=3;
        gbc.gridy=2;
        gbc.gridwidth=2;
        gbc.gridheight=1;
        gbc.weightx=0.4;
        gbc.weighty=0.7;
        jpCenter.add(jpEnemy,gbc);

        //ս��ͼ��
        gbc.gridx=2;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=0.2;
        gbc.weighty=0.15;
        jpCenter.add(jlbCombatImage,gbc);

        //ս��ѡ��
        gbc.gridx=2;
        gbc.gridy=2;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        gbc.weightx=0.2;
        gbc.weighty=0.7;
        jpCenter.add(jpCombat,gbc);

        this.add(jpCenter);
        //���ò��ֹ�����
        this.setLayout(new GridLayout());
        //���������ñ���
        this.setTitle("ս������");
        //���ô����С
        this.setSize(750,270);
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

        combatSystem = new CombatSystem(enemy,r);
        if(e.getActionCommand()==common.getName()){
            atk = r.attack(common);
        }else if(e.getActionCommand()==skills.get(0).getName()){
            if(r.getCurrentmp()<skills.get(0).getMp()){
                JOptionPane.showMessageDialog(null,"ħ��ֵ���㣺"+r.getCurrentmp()+"/"+skills.get(0).getMp(),"��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
                atk=0;
            }else {
                atk = r.attack(skills.get(0));
            }
        }else if(e.getActionCommand()==skills.get(1).getName()){
            if(r.getCurrentmp()<skills.get(1).getMp()){
                JOptionPane.showMessageDialog(null,"ħ��ֵ���㣺"+r.getCurrentmp()+"/"+skills.get(1).getMp(),"��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
                atk=0;
            }else {
                atk = r.attack(skills.get(1));
            }
        }else if(e.getActionCommand()==skills.get(2).getName()){
            if(r.getCurrentmp()<skills.get(2).getMp()){
                JOptionPane.showMessageDialog(null,"ħ��ֵ���㣺"+r.getCurrentmp()+"/"+skills.get(2).getMp(),"��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
                atk=0;
            }else {
                atk = r.attack(skills.get(2));
            }
        }
        if(atk!=0){//ħ��ֵ�㹻
            int result = combatSystem.roleAttackEnemy(atk);//��ɫ����
            if (result == 0){
                r.Victory(enemy.getEnemyname());//�������� ��ȡ��������

                gameStart.jlbCurrentHp.setText("��ǰhp:"+r.getCurrenthp()+"  ");
                gameStart.jlbMaxHp.setText("���hp:"+r.getMaxhp()+"  ");
                gameStart.jlbCurrentMP.setText("��ǰmp:"+r.getCurrentmp()+"  ");
                gameStart.jlbMaxMp.setText("���mp:"+r.getMp()+"  ");
                gameStart.jlbAtk.setText("Atk:"+r.getAtk()+"  ");
                gameStart.jlbDef.setText("Def:"+r.getDef()+"  ");
                gameStart.jlbExp.setText("����ֵ:"+r.getExp()+"/"+r.getRoleCareer().useStage(r.getLevel())+"  ");
                gameStart.jlbLevel.setText("�ȼ�:"+r.getLevel()+"  ");
                gameStart.jlbStrength.setText("����:"+r.getStrength()+"  ");
                gameStart.jlbIntl.setText("����:"+r.getIntl()+"  ");
                gameStart.jlbSpeed.setText("�ٶ�:"+r.getSpeed()+"  ");

                dispose();
            }else {
                jlbEcurrentHp.setText("��ǰhp��"+enemy.getHp()+"  ");//��������¹�������
                JOptionPane.showMessageDialog(null,"����ʣ������:"+enemy.getHp(),"��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
                JOptionPane.showMessageDialog(null,"����������й�����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
                int ss = combatSystem.EnemyAttackRole(enemy.Attack());//���﹥�� ����ȡ��ɫʣ��Ѫ��
                jlbCurrentHp.setText("��ǰhp:"+r.getCurrenthp()+"  ");
                r.updateState();//���½�ɫս��״̬
                //��ɫս��״̬��ȡ
                if(r.getState().toString()=="����"&& ss != 0)
                {
                    JOptionPane.showMessageDialog(null,"���ĸ���״̬��"+r.getState()+", �������50%�Ĺ������ӳ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
                }
                else if(r.getState().toString()=="����"&& ss != 0){
                    JOptionPane.showMessageDialog(null,"���ĸ���״̬��"+r.getState(),"��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
                }
                if (ss == 0) {
                    System.exit(0);
                }
            }
        }

    }
}
