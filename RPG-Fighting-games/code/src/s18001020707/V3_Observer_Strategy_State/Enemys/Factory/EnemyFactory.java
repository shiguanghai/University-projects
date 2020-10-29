package s18001020707.V3_Observer_Strategy_State.Enemys.Factory;

import s18001020707.V3_Observer_Strategy_State.Enemys.Enemy;

import java.util.HashMap;

public class EnemyFactory {

    private static HashMap<String, Enemy> pool=new HashMap<>();//创建map集合

    public static Enemy getEnemy(String monstername){
        Enemy enemy=null;
        if (pool.containsKey(monstername)){//已经存在则取出对象
            enemy=pool.get(monstername);
        }
        else{//不存在则创建对象
            if (monstername.equals("落魄子弟")){
                EnemyAFactory fa=new EnemyAFactory();
                enemy=fa.CreateEnemy();
            }
            if (monstername.equals("歪门邪道")){
                EnemyBFactory fb=new EnemyBFactory();
                enemy=fb.CreateEnemy();
            }
            if (monstername.equals("鬼怪妖魔")){
                EnemyCFactory fc=new EnemyCFactory();
                enemy=fc.CreateEnemy();
            }
        }
        pool.put(monstername,enemy);

        return enemy;//返回对象
    }

}
