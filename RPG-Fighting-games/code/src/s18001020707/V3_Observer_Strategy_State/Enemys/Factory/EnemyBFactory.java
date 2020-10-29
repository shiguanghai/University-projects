package s18001020707.V3_Observer_Strategy_State.Enemys.Factory;

import s18001020707.V3_Observer_Strategy_State.Enemys.Enemy;
import s18001020707.V3_Observer_Strategy_State.Enemys.EnemyB;

public class EnemyBFactory implements Factory {
    @Override
    public Enemy CreateEnemy() { return new EnemyB(); }
}
