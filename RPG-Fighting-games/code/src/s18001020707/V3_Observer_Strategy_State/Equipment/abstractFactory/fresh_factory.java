package s18001020707.V3_Observer_Strategy_State.Equipment.abstractFactory;

import s18001020707.V3_Observer_Strategy_State.Equipment.Clothes.Clothes;
import s18001020707.V3_Observer_Strategy_State.Equipment.Clothes.imp.freshClothes;
import s18001020707.V3_Observer_Strategy_State.Equipment.Weapon.Weapon;
import s18001020707.V3_Observer_Strategy_State.Equipment.Weapon.imp.freshWeapon;

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
