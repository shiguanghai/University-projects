package pkg0311.n1;

public class Test {
    public static void main(String[] args) {
        Shares shares = new SharesEvent();
        SharesPeople p1 = new SharesPeople("С��");
        SharesPeople p2 = new SharesPeople("С��");

        shares.attach(p1);
        shares.attach(p2);

        shares.notifyPeople(98);
        System.out.println("*******************");
        shares.notifyPeople(92);
    }

}
