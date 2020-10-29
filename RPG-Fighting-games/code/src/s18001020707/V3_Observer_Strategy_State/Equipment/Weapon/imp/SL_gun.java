package s18001020707.V3_Observer_Strategy_State.Equipment.Weapon.imp;

import s18001020707.V3_Observer_Strategy_State.Equipment.Weapon.Weapon;

public class SL_gun extends Weapon {
    public SL_gun(){
        this.Atk = 200;
        this.name = "ÉÙÁÖ¹÷";
    }

    @Override
    public String toString() {
        return name;
    }
}
