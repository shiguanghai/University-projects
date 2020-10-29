package s18001020707.V2_Decorator.Equipment.Clothes.imp;

import s18001020707.V2_Decorator.Equipment.Clothes.Clothes;

public class freshClothes extends Clothes {

    public freshClothes() {
        this.Def = 100;
        this.name = "ÐÂÊÖ·À¾ß";
    }

    @Override
    public String toString() {
        return name;
    }

}
