package pkg0228.v4;

public abstract class Duck {
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;
    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior){
        super();
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }
    public abstract void display();
    public void swim(){
        System.out.println("I can swim.");
    }
    public void fly(){
        flyBehavior.fly();//fly行为是从属性flyBehavior中得到的
    }
    public void quack(){
        quackBehavior.quack();
    }
}
