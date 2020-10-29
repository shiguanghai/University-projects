package s18001020707.V2_Decorator.Equipment.abstractFactory;

import s18001020707.V2_Decorator.Equipment.Clothes.Clothes;
import s18001020707.V2_Decorator.Equipment.Clothes.imp.superiorClothes;
import s18001020707.V2_Decorator.Equipment.Weapon.Weapon;
import s18001020707.V2_Decorator.Equipment.Weapon.imp.TM_Biao;

public class Tm_factory implements AbstractFactory {
    @Override
    public Weapon CreateWeapon() {
        return new TM_Biao();
    }

    @Override
    public Clothes CreateClothes() {
        return new superiorClothes();
    }
}
