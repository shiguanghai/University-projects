package pkg0228.v4;


public class Wooden extends Duck{
    public Wooden(){
        super(new FlyNoWay(),new Mute());
    }
    public void display(){
        System.out.println("I am Wooden.");
    }

}
