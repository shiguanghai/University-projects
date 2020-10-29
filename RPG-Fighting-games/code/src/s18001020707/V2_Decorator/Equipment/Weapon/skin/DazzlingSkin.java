package s18001020707.V2_Decorator.Equipment.Weapon.skin;

import s18001020707.V2_Decorator.Equipment.Weapon.Weapon;

public class DazzlingSkin extends Skin{
    public DazzlingSkin(Weapon weapon) {
        super(weapon);
    }

    @Override
    public String toString(){
        return "Ï≈≤ °§"+weapon.toString();
    }
}
