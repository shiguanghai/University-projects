package s18001020707.V1_more.Combat;

import s18001020707.V1_more.Enemys.Enemy;
import s18001020707.V1_more.People.Role;

public abstract class AbstractCombat {
    //中介者模式
    protected Enemy enemy;//敌人
    protected Role role;//角色

    public AbstractCombat(Enemy enemy,Role role){
        this.enemy = enemy;
        this.role = role;
    }

    public abstract int roleAttackEnemy(int AtkRole);

    public abstract int EnemyAttackRole(int AtkEnemy);
}
