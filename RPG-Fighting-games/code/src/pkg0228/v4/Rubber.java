package pkg0228.v4;

public class Rubber extends Duck {
    public Rubber(){
        super(new FlyNoWay(),new Squeak());
    }
    public void display(){
        System.out.println("I am Rubber.");
    }
}
