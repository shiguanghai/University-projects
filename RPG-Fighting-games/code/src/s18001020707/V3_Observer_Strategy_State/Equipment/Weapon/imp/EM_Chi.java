package s18001020707.V3_Observer_Strategy_State.Equipment.Weapon.imp;

import s18001020707.V3_Observer_Strategy_State.Equipment.Weapon.Weapon;

public class EM_Chi extends Weapon {
    public EM_Chi(){
        this.name = "��ü��";
        this.Atk = 200;
    }

    @Override
    public String toString() {
        return name;
    }
}
