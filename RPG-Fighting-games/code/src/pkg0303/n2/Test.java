package pkg0303.n2;

public class Test {
    public static void main(String[] args) {
        Character c = new King();
        c.fight();
        c.useWeapon();
        System.out.println("change weapon for Axe");
        c.setWeapom(new AxeBehavior());
        c.useWeapon();
    }
}
