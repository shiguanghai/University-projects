package s18001020707.V3_Observer_Strategy_State.Equipment.Weapon.skin;

import s18001020707.V3_Observer_Strategy_State.Equipment.Weapon.Weapon;

public abstract class Skin extends Weapon {
    //װ����ģʽΪ��������Ƥ��

    protected Weapon weapon;

    public Skin(Weapon weapon){this.weapon=weapon;}

    public abstract String toString();
}
