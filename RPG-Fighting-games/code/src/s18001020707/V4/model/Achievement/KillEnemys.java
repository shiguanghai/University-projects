package s18001020707.V4.model.Achievement;

import java.util.ArrayList;
import java.util.List;

public abstract class KillEnemys {

    //�۲���ģʽʵ�ֳɾ�ϵͳ
    private List<Observer> observers = new ArrayList<Observer>();
    public void registerObserver(Observer observer){observers.add(observer);}
    public void deleteObserver(Observer observer){observers.remove(observer);}
    public abstract int notify(String enemy, int death);
}
