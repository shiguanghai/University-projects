package s18001020707.V1_more.Equipment.abstractFactory;

import s18001020707.V1_more.Equipment.Clothes.Clothes;
import s18001020707.V1_more.Equipment.Weapon.Weapon;

public interface AbstractFactory {
    Weapon CreateWeapon();

    Clothes CreateClothes();

}
