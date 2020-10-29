package s18001020707.V3_Observer_Strategy_State.Combat;

import s18001020707.V3_Observer_Strategy_State.Enemys.Enemy;
import s18001020707.V3_Observer_Strategy_State.People.Role;

public abstract class AbstractCombat {
    //�н���ģʽ�������ͽ�ɫ
    protected Enemy enemy;//����
    protected Role role;//��ɫ

    public AbstractCombat(Enemy enemy, Role role){
        this.enemy = enemy;
        this.role = role;
    }

    public abstract int roleAttackEnemy(int AtkRole);

    public abstract int EnemyAttackRole(int AtkEnemy);
}
