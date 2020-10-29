package s18001020707.V2_Decorator.Enemys;

import s18001020707.V2_Decorator.Enemys.Factory.EnemyFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CloneEnemy {
    //调用工厂生产怪物的方式
    public Enemy getEnemyclone(String name) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Enemy a= EnemyFactory.getEnemy(name);
        Class<?> ss=a.getClass();
        Method clonemethod=ss.getMethod("clone");
        Object c=clonemethod.invoke(ss.newInstance());
        Enemy d=(Enemy) c;
        return d;
    }
}
