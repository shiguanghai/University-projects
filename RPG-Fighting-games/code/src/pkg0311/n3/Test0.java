package pkg0311.n3;

public class Test0 {
    public static void main(String[] args) {
        cage c = new cage();
        Treasure gold = new Gold();
        Treasure diamond = new Diamond();

        Eudemon tiger0 = new Tiger();
        Eudemon tiger1 = new Tiger();
        Eudemon tiger2 = new Tiger();

        Eudemon lion0 = new Lion();
        Eudemon lion1 = new Lion();


        gold.guard(lion0);
        gold.guard(lion1);
        gold.guard(tiger2);

        diamond.guard(tiger0);
        diamond.guard(tiger1);

        c.take(gold);
    }
}
