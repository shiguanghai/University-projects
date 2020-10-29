package s18001020707.V2_Decorator.Command;

import s18001020707.V2_Decorator.Equipment.Weapon.Weapon;

public class weaponCommand implements Command {
    private Weapon weapon;

    public weaponCommand(Weapon weapon){
        this.weapon = weapon;
    }

    @Override
    public void execute(String username) {
        weapon.getWeapon(username);
    }
}
