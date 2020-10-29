package s18001020707.V4.model.Equipment.Weapon.skin;

import s18001020707.V4.model.Equipment.Weapon.Weapon;

public class DazzlingSkin extends Skin {
    public DazzlingSkin(Weapon weapon) {
        super(weapon);
        this.Atk=weapon.getAtk();
        this.name="Ï≈≤ °§"+weapon.toString();
    }

    @Override
    public String toString(){
        return name;
    }
}
