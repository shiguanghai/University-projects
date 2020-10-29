package s18001020707.V2_Decorator.Enemys;

public class EnemyA extends Enemy {

    public EnemyA(){
        this.Enemyname="落魄子弟";
        this.atk=100;
        this.def=30;
        this.hp=300;
        this.mp=300;
    }

    @Override
    public int Attack() {
        return this.atk;
    }

    @Override
    public EnemyA clone(){
        EnemyA o = null;
        try {
             o = (EnemyA) super.clone();
        } catch (CloneNotSupportedException e) {
             System.out.println(e.toString());
        }
        return o;
    }

    @Override
    public void useAtk() {
        System.out.println(this.Enemyname + "发起了普通攻击");
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
