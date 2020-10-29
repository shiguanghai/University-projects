package s18001020707.V4.model.Equipment.Weapon.skin;

import s18001020707.V4.model.Equipment.Weapon.Weapon;

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
