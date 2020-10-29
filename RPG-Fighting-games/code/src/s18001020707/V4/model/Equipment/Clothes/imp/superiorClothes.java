package s18001020707.V4.model.Equipment.Clothes.imp;

import s18001020707.V4.model.Equipment.Clothes.Clothes;

public class superiorClothes extends Clothes {
    public superiorClothes() {
        this.Def = 200;
        this.name = "¸ß¼¶·À¾ß";
    }

    @Override
    public String toString() {
        return name;
    }
}
