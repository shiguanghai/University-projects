package s18001020707.V4.model.Combat;

import s18001020707.V4.model.Enemys.Enemy;
import s18001020707.V4.model.People.Role;

import javax.swing.*;

public class CombatSystem extends AbstractCombat {
    public CombatSystem(Enemy enemy, Role role) {
        super(enemy, role);
    }

    @Override
    public int roleAttackEnemy(int AtkRole) {//��ɫ��������
        int hp = enemy.getHp();//����Ѫ��
        int hurt = AtkRole - enemy.getDef();//�˺�=����-���˷���
        if (hurt>0){//����˺�
            enemy.setHp(hp - hurt);
        }
        if (enemy.getHp()>0){//���˴��
            return 1;  //ս������
        }else {//��������
            JOptionPane.showMessageDialog(null,"��ɱ���˶Է�������˴������飡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
            System.out.println("��ɱ���˶Է�������˴������飡");
            return 0;  //����������ս������
        }
    }

    @Override
    public int EnemyAttackRole(int AtkEnemy) {//���˹�����ɫ
        int hp = role.getCurrenthp();//�ִ�Ѫ��
        int hurt = AtkEnemy - role.getDef();
        if (hurt>0){
            role.setCurrenthp(hp - hurt);
            if(role.getCurrenthp()>0){
                JOptionPane.showMessageDialog(null,"���ִ�Ѫ����"+role.getCurrenthp()+"/"+role.getMaxhp(),"��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
                System.out.println("���ִ�Ѫ����"+role.getCurrenthp()+"/"+role.getMaxhp());
            }
        }
        if (role.getCurrenthp()>0){
            return 1;
        }else {
            System.out.println("�Է�ɱ�����㣡");
            return 0;
        }
    }
}
