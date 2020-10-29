package s18001020707.V2_Decorator.Equipment.Weapon.imp;

import s18001020707.V2_Decorator.Equipment.Weapon.Weapon;

public class SL_gun extends Weapon {
    public SL_gun(){
        this.Atk = 200;
        this.name = "…Ÿ¡÷π˜";
    }

    @Override
    public String toString() {
        return name;
    }
}
