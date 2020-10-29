package pkg0303.n2;

public abstract class Character {

	protected WeaponBehavior weapon;
	public Character(WeaponBehavior weaponBehavior){
		super();
		this.weapon=weaponBehavior;
	}
	public abstract void fight();
	public void setWeapom(WeaponBehavior w) {
		this.weapon = w;
	}
	public void useWeapon(){
		weapon.useWeapon();
	}

}
