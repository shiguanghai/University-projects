package s18001020707.V2_Decorator.Equipment.Weapon.imp;

import s18001020707.V2_Decorator.Equipment.Weapon.Weapon;

public class freshWeapon extends Weapon {

    public freshWeapon(){
        this.name = "ĞÂÊÖÎäÆ÷";
        this.Atk = 100;
    }

    @Override
    public String toString() {
        return name;
    }
}
