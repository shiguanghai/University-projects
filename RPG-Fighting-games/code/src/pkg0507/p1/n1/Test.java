package pkg0507.p1.n1;

public class Test {
    public static void main(String[] args) {
        ConcretAggregate concretAggregate = new ConcretAggregate(new ConcretIterator(5));
        TVIterator tvIterator = concretAggregate.createIterator();

        for (int i = 0; i < 10; i++){
            if(i < 5){
                tvIterator.previous();
            } else {
                tvIterator.next();
            }
        }
    }

}
