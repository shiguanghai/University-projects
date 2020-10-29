package pkg0306.v5;

public class Rubber extends Duck {
    public Rubber(){
        super(new FlyNoWay(),new Squeak());
    }
    public void display(){
        System.out.println("I am Rubber.");
    }
}
