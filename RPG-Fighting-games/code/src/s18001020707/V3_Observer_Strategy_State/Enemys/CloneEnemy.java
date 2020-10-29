package s18001020707.V3_Observer_Strategy_State.Enemys;

import s18001020707.V3_Observer_Strategy_State.Enemys.Factory.EnemyFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CloneEnemy {
    //调用工厂生产怪物的方式
    public Enemy getEnemyclone(String name) throws NoSuchMethodException, IllegalAccessException,
            InstantiationException, InvocationTargetException {
        Enemy a= EnemyFactory.getEnemy(name);//创建对象 不能直接返回 否则会取到以前的对象
        Class<?> ss=a.getClass();//返回对象所属类
        //利用java反射机制可以在运行时调用任意一个对象的方法执行该对象的clone方法
        Method clonemethod=ss.getMethod("clone");//返回新对象
        Object c=clonemethod.invoke(ss.newInstance());//通过newInstance返回object对象
        Enemy d=(Enemy) c;
        return d;
    }
}
