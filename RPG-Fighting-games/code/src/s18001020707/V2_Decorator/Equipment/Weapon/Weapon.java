package s18001020707.V2_Decorator.Equipment.Weapon;

import s18001020707.V2_Decorator.Equipment.Equipment;

public class Weapon extends Equipment {

    //����¼ģʽ
    Weapon saveState(){
        Weapon weapon = new Weapon();
        weapon.setAtk(getAtk());
        weapon.setName(getName());
        return weapon;
    }


    public void getWeapon(String username){
        System.out.println(username + "ʹ��" + getName() + "���й���");
    }

    public void levelup(){
        this.Atk += 10;
    }

    public int getAtk(){
        return this.Atk;
    }

    public String toString(){
        return getName();
    }


}
