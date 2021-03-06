package s18001020707.V4.model.Equipment.abstractFactory;

import s18001020707.V4.model.Equipment.Clothes.Clothes;
import s18001020707.V4.model.Equipment.Clothes.imp.freshClothes;
import s18001020707.V4.model.Equipment.Weapon.Weapon;
import s18001020707.V4.model.Equipment.Weapon.imp.freshWeapon;

public class fresh_factory implements AbstractFactory {
    @Override
    public Weapon CreateWeapon() {
        return new freshWeapon();
    }

    @Override
    public Clothes CreateClothes() {
        return new freshClothes();
    }
}
