package s18001020707.V2_Decorator.Equipment.abstractFactory;

import s18001020707.V2_Decorator.Equipment.Clothes.Clothes;
import s18001020707.V2_Decorator.Equipment.Weapon.Weapon;

public interface AbstractFactory {
    Weapon CreateWeapon();

    Clothes CreateClothes();

}
