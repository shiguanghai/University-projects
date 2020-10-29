package s18001020707.V2_Decorator.Combat;

import s18001020707.V2_Decorator.Enemys.Enemy;
import s18001020707.V2_Decorator.People.Role;

public abstract class AbstractCombat {
    //中介者模式解耦怪物和角色
    protected Enemy enemy;//怪物
    protected Role role;//角色

    public AbstractCombat(Enemy enemy, Role role){
        this.enemy = enemy;
        this.role = role;
    }

    public abstract int roleAttackEnemy(int AtkRole);

    public abstract int EnemyAttackRole(int AtkEnemy);
}
