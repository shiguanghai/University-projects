package s18001020707.V2_Decorator.Equipment.Clothes;

import s18001020707.V2_Decorator.Equipment.Equipment;


public class Clothes extends Equipment {
    //备忘录模式，保存防具状态
    Clothes saveState(){
        Clothes clothes = new Clothes();
        clothes.setDef(getDef());
        clothes.setName(getName());
        return clothes;
    }

    public void levelup(){
        this.Def += 10;
    }

    @Override
    public String toString() {
        return  name;
    }

    public int getDef(){
        return Def;
    }
}
