package s18001020707.V3_Observer_Strategy_State.Equipment.Weapon.imp;

import s18001020707.V3_Observer_Strategy_State.Equipment.Weapon.Weapon;

public class TM_Biao extends Weapon {
    public TM_Biao(){
        this.Atk = 200;
        this.name = "������";
    }

    @Override
    public String toString() {
        return name;
    }
}
