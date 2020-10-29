package s18001020707.V3_Observer_Strategy_State.Equipment.abstractFactory;

import s18001020707.V3_Observer_Strategy_State.Equipment.Clothes.Clothes;
import s18001020707.V3_Observer_Strategy_State.Equipment.Weapon.Weapon;

public interface AbstractFactory {
    Weapon CreateWeapon();

    Clothes CreateClothes();

}
