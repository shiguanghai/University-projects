package s18001020707.V3_Observer_Strategy_State.Equipment.Weapon.imp;

import s18001020707.V3_Observer_Strategy_State.Equipment.Weapon.Weapon;

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
