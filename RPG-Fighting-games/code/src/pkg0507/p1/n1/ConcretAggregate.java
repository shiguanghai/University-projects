package pkg0507.p1.n1;

public class ConcretAggregate implements Television {
    private ConcretIterator concretIterator;


    public ConcretAggregate(ConcretIterator concretIterator) {
        this.concretIterator = concretIterator;
    }

    public TVIterator createIterator() {
        return this.concretIterator;
    }


}
