package s18001020707.V1_more.Equipment.abstractFactory;

import s18001020707.V1_more.Equipment.Clothes.Clothes;
import s18001020707.V1_more.Equipment.Clothes.imp.superiorClothes;
import s18001020707.V1_more.Equipment.Weapon.Weapon;
import s18001020707.V1_more.Equipment.Weapon.imp.SL_gun;

public class Sl_factory implements AbstractFactory{
    @Override
    public Weapon CreateWeapon() {
        return new SL_gun();
    }

    @Override
    public Clothes CreateClothes() {
        return new superiorClothes();
    }
}
