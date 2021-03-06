package s18001020707.V2_Decorator.Equipment.abstractFactory;

import s18001020707.V2_Decorator.Equipment.Clothes.Clothes;
import s18001020707.V2_Decorator.Equipment.Clothes.imp.superiorClothes;
import s18001020707.V2_Decorator.Equipment.Weapon.Weapon;
import s18001020707.V2_Decorator.Equipment.Weapon.imp.SL_gun;

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
