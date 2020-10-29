package pkg0306.v5;

public class Rocket extends Duck {
    public Rocket(){
        super(new FlyWithFire(),new Roar());
    }
    public void display(){
        System.out.println("I am Rocket.");
    }
}
