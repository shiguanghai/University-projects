package s18001020707.V3_Observer_Strategy_State.Enemys;

public class EnemyB extends Enemy {

    public EnemyB(){
        this.Enemyname="歪门邪道";
        this.atk=300;
        this.def=10;
        this.hp=2000;
        this.mp=300;
    }

    @Override
    public int Attack() {
        return this.atk;
    }

    @Override
    public void useAtk() {
        System.out.println(this.Enemyname + "发起了普通攻击");
    }

    @Override
    public EnemyB clone(){
        EnemyB o = null;
        try {
            o = (EnemyB) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        return o;
    }

    @Override
    public String toString() {
        return "敌人名字:" + Enemyname +
                ",hp=" + hp +
                ", mp=" + mp +
                ", atk=" + atk +
                ", def=" + def ;

    }
}
