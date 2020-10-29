package pkg0306.v5;


public class Wooden extends Duck {
    public Wooden(){
        super(new FlyNoWay(),new Mute());
    }
    public void display(){
        System.out.println("I am Wooden.");
    }

}
