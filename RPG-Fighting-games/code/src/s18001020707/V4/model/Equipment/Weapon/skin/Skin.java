package s18001020707.V4.model.Equipment.Weapon.skin;

import s18001020707.V4.model.Equipment.Weapon.Weapon;

public abstract class Skin extends Weapon {
    //װ����ģʽΪ��������Ƥ��

    protected Weapon weapon;

    public Skin(Weapon weapon){this.weapon=weapon;}

    public abstract String toString();
}
