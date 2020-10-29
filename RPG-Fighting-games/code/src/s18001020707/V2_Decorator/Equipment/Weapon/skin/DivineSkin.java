package s18001020707.V2_Decorator.Equipment.Weapon.skin;

import s18001020707.V2_Decorator.Equipment.Weapon.Weapon;

public class DivineSkin extends Skin {
    public DivineSkin(Weapon weapon) {
        super(weapon);
    }

    @Override
    public String toString() {
        return "Éñ¼¶¡¤"+weapon.toString();
    }
}
