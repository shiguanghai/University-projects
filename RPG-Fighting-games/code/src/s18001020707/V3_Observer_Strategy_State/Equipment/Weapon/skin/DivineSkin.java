package s18001020707.V3_Observer_Strategy_State.Equipment.Weapon.skin;

import s18001020707.V3_Observer_Strategy_State.Equipment.Weapon.Weapon;

public class DivineSkin extends Skin {
    public DivineSkin(Weapon weapon) {
        super(weapon);
        this.Atk=weapon.getAtk();
        this.name="Éñ¼¶¡¤"+weapon.toString();
    }

    @Override
    public String toString() {
        return name;
    }
}
