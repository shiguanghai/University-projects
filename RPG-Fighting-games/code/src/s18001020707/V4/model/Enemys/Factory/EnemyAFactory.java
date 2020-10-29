package s18001020707.V4.model.Enemys.Factory;


import s18001020707.V4.model.Enemys.Enemy;
import s18001020707.V4.model.Enemys.EnemyA;

public class EnemyAFactory implements Factory {
    @Override
    public Enemy CreateEnemy() { return new EnemyA(); }
}
