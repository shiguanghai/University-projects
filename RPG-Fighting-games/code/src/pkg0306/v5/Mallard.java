package pkg0306.v5;

public class Mallard extends Duck {
    public Mallard(){
        super(new FlyWithWings(),new Quack());
    }
    public void display(){
        System.out.println("I am Mallard.");
    };
}
