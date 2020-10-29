package s18001020707.V3_Observer_Strategy_State.Enemys;

import s18001020707.V3_Observer_Strategy_State.Enemys.Factory.EnemyFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CloneEnemy {
    //���ù�����������ķ�ʽ
    public Enemy getEnemyclone(String name) throws NoSuchMethodException, IllegalAccessException,
            InstantiationException, InvocationTargetException {
        Enemy a= EnemyFactory.getEnemy(name);//�������� ����ֱ�ӷ��� �����ȡ����ǰ�Ķ���
        Class<?> ss=a.getClass();//���ض���������
        //����java������ƿ���������ʱ��������һ������ķ���ִ�иö����clone����
        Method clonemethod=ss.getMethod("clone");//�����¶���
        Object c=clonemethod.invoke(ss.newInstance());//ͨ��newInstance����object����
        Enemy d=(Enemy) c;
        return d;
    }
}
