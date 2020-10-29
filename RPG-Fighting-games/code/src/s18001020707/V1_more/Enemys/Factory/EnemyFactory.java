package s18001020707.V1_more.Enemys.Factory;

import s18001020707.V1_more.Enemys.Enemy;

import java.util.HashMap;

public class EnemyFactory {

    private static HashMap<String, Enemy> pool=new HashMap<>();

    public static Enemy getEnemy(String monstername){
        Enemy enemy=null;
        if (pool.containsKey(monstername)){
            enemy=pool.get(monstername);
        }
        else{
            if (monstername.equals("�����ӵ�")){
                EnemyAFactory fa=new EnemyAFactory();
                enemy=fa.CreateEnemy();
            }
            if (monstername.equals("����а��")){
                EnemyBFactory fb=new EnemyBFactory();
                enemy=fb.CreateEnemy();
            }
            if (monstername.equals("�����ħ")){
                EnemyCFactory fc=new EnemyCFactory();
                enemy=fc.CreateEnemy();
            }
        }
        pool.put(monstername,enemy);
        return enemy;
    }

}
