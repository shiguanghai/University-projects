package s18001020707.V2_Decorator.Enemys.Factory;

import s18001020707.V2_Decorator.Enemys.Enemy;
import s18001020707.V2_Decorator.Enemys.EnemyC;

public class EnemyCFactory implements Factory {
    @Override
    public Enemy CreateEnemy() { return new EnemyC(); }
}
