package s18001020707.V1_more.Equipment.Clothes;

import s18001020707.V1_more.Equipment.Equipment;


public class Clothes extends Equipment {
    //����¼ģʽ������״̬
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
