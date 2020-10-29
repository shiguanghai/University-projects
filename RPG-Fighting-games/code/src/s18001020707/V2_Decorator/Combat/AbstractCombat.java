package s18001020707.V2_Decorator.Combat;

import s18001020707.V2_Decorator.Enemys.Enemy;
import s18001020707.V2_Decorator.People.Role;

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
