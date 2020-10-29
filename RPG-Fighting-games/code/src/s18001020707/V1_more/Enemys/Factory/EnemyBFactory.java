package s18001020707.V1_more.Enemys.Factory;

import s18001020707.V1_more.Enemys.Enemy;
import s18001020707.V1_more.Enemys.EnemyB;

public class EnemyBFactory implements Factory{
    @Override
    public Enemy CreateEnemy() { return new EnemyB(); }
}
