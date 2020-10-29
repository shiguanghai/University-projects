package s18001020707.V4.model.Enemys;

import javax.swing.*;

public class EnemyC extends Enemy {

    public EnemyC(){
        this.Enemyname="������ħ";
        this.atk=300;
        this.def=20;
        this.hp=4000;
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
