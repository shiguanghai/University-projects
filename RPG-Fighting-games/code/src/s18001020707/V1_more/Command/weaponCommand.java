package s18001020707.V1_more.Command;

import s18001020707.V1_more.Equipment.Weapon.Weapon;

public class weaponCommand implements Command{
    private Weapon weapon;

    public weaponCommand(Weapon weapon){
        this.weapon = weapon;
    }

    @Override
    public void execute(String username) {
        weapon.getWeapon(username);
    }
}
