package s18001020707.V4.model.Combat;

import s18001020707.V4.model.Enemys.Enemy;
import s18001020707.V4.model.People.Role;

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
