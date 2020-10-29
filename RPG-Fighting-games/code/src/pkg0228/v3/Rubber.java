package pkg0228.v3;


public class Rubber extends Duck implements QuackBehavior{
    public void display(){
        System.out.println("I am Rubber.");
    }
    public void quack(){
        System.out.println("I can squeak.");
    };
}
