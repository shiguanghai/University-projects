package s18001020707.V1_more.Enemys.Factory;


import s18001020707.V1_more.Enemys.Enemy;
import s18001020707.V1_more.Enemys.EnemyA;

public class EnemyAFactory implements Factory {
    @Override
    public Enemy CreateEnemy() { return new EnemyA(); }
}
