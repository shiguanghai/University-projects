package pkg0228.v3;

public class Test {
    public static void main(String[] args) {
        Duck d = new Mallard();
        d.display();
        d.swim();
        ((FlyBehavior)d).fly();
        ((QuackBehavior)d).quack();
    }
}
