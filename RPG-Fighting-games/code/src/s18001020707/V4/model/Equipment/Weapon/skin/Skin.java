package s18001020707.V4.model.Equipment.Weapon.skin;

import s18001020707.V4.model.Equipment.Weapon.Weapon;

public abstract class Skin extends Weapon {
    //装饰者模式为武器增加皮肤

    protected Weapon weapon;

    public Skin(Weapon weapon){this.weapon=weapon;}

    public abstract String toString();
}
