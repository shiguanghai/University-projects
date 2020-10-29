package s18001020707.V3_Observer_Strategy_State.Enemys;

public class EnemyB extends Enemy {

    public EnemyB(){
        this.Enemyname="����а��";
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
        System.out.println(this.Enemyname + "��������ͨ����");
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
        return "��������:" + Enemyname +
                ",hp=" + hp +
                ", mp=" + mp +
                ", atk=" + atk +
                ", def=" + def ;

    }
}
