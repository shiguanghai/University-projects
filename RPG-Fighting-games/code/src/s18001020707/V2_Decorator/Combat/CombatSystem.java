package s18001020707.V2_Decorator.Combat;

import s18001020707.V2_Decorator.Enemys.Enemy;
import s18001020707.V2_Decorator.People.Role;

public class CombatSystem extends AbstractCombat {
    public CombatSystem(Enemy enemy, Role role) {
        super(enemy, role);
    }

    @Override
    public int roleAttackEnemy(int AtkRole) {//角色攻击敌人
        int hp = enemy.getHp();//敌人血量
        int hurt = AtkRole - enemy.getDef();//伤害=攻击-敌人防御
        if (hurt>0){//造成伤害
            enemy.setHp(hp - hurt);
        }
        if (enemy.getHp()>0){//敌人存活
            return 1;  //战斗继续
        }else {//敌人死亡
            System.out.println("你杀死了对方并获得了大量经验！");
            return 0;  //敌人死亡，战斗结束
        }
    }

    @Override
    public int EnemyAttackRole(int AtkEnemy) {//敌人攻击角色
        int hp = role.getCurrenthp();//现存血量
        int hurt = AtkEnemy - role.getDef();
        if (hurt>0){
            role.setCurrenthp(hp - hurt);
        }
        if (role.getCurrenthp()>0){
            return 1;
        }else {
            System.out.println("对方杀死了你！");
            return 0;
        }
    }
}
