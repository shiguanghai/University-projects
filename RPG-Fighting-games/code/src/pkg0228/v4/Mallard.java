package pkg0228.v4;

public class Mallard extends Duck {
    public Mallard(){
        super(new FlyWithWings(),new Quack());
    }
    public void display(){
        System.out.println("I am Mallard.");
    };
}
