package s18001020707.V4.model.Equipment.Weapon.imp;

import s18001020707.V4.model.Equipment.Weapon.Weapon;

public class SL_gun extends Weapon {
    public SL_gun(){
        this.Atk = 200;
        this.name = "���ֹ�";
    }

    @Override
    public String toString() {
        return name;
    }
}
