package s18001020707.V2_Decorator.Equipment.Weapon.imp;

import s18001020707.V2_Decorator.Equipment.Weapon.Weapon;

public class TM_Biao extends Weapon {
    public TM_Biao(){
        this.Atk = 200;
        this.name = "Ã∆√≈Ô⁄";
    }

    @Override
    public String toString() {
        return name;
    }
}
