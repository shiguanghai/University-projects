package pkg0327.pizza.v1;

public class ClamPizza extends Pizza{
    public void prepare() {
        System.out.print("Clam ");
        super.prepare();
    }
    public void bake() {
        System.out.print("Clam ");
        super.bake();
    }
    public void cut() {
        System.out.print("Clam ");
        super.cut();
    }
    public void box() {
        System.out.print("Clam ");
        super.box();
    }
}
