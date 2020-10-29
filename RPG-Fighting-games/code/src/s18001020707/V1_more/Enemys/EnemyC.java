package s18001020707.V1_more.Enemys;

public class EnemyC extends Enemy {

    public EnemyC(){
        this.Enemyname="�����ħ";
        this.atk=300;
        this.def=10;
        this.hp=3000;
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
    public EnemyC clone(){
        EnemyC o = null;
        try {
            o = (EnemyC) super.clone();
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
