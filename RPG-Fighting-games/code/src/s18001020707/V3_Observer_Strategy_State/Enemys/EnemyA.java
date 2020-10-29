package s18001020707.V3_Observer_Strategy_State.Enemys;

public class EnemyA extends Enemy {

    public EnemyA(){
        this.Enemyname="�����ӵ�";
        this.atk=100;
        this.def=30;
        this.hp=500;
        this.mp=300;
    }

    @Override
    public int Attack() {
        return this.atk;
    }

    @Override
    public EnemyA clone(){//�����¸���
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
        System.out.println(this.Enemyname + "��������ͨ����");
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
