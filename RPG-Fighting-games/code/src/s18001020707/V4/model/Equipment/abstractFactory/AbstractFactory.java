package s18001020707.V4.model.Equipment.abstractFactory;

import s18001020707.V4.model.Equipment.Clothes.Clothes;
import s18001020707.V4.model.Equipment.Weapon.Weapon;

public interface AbstractFactory {
    Weapon CreateWeapon();

    Clothes CreateClothes();

}
