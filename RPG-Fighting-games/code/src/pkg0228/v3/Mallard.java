package pkg0228.v3;

public class Mallard extends Duck implements FlyBehavior,QuackBehavior{
    public void display(){
        System.out.println("I am Mallard.");
    };
    public void fly(){
        System.out.println("I can fly.");
    };
    public void quack(){
        System.out.println("I can quack.");
    };
}
