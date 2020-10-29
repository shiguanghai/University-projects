package s18001020707.V4.model.Equipment.abstractFactory;

import s18001020707.V4.model.Equipment.Clothes.Clothes;
import s18001020707.V4.model.Equipment.Clothes.imp.superiorClothes;
import s18001020707.V4.model.Equipment.Weapon.Weapon;
import s18001020707.V4.model.Equipment.Weapon.imp.SL_gun;

public class Sl_factory implements AbstractFactory {
    @Override
    public Weapon CreateWeapon() {
        return new SL_gun();
    }

    @Override
    public Clothes CreateClothes() {
        return new superiorClothes();
    }
}
