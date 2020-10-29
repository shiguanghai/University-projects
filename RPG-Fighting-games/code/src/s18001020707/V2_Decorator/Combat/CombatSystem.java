package s18001020707.V2_Decorator.Combat;

import s18001020707.V2_Decorator.Enemys.Enemy;
import s18001020707.V2_Decorator.People.Role;

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
        }
        if (role.getCurrenthp()>0){
            return 1;
        }else {
            System.out.println("�Է�ɱ�����㣡");
            return 0;
        }
    }
}
