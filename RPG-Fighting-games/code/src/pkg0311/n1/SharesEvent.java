package pkg0311.n1;

public class SharesEvent extends Shares {
    @Override
    public void notifyPeople(int num) {
        // TODO Auto-generated method stub
        if ((num >100*(1+0.05))||(num <100*(1-0.05))) {
            for (Object obj : people) {
                System.out.print("***��Ʊ�仯��");
                ((SharesPeople) obj).response();
            }
        } else {
            System.out.print("��Ʊ�仯��");
            System.out.println("����..");
        }
    }
}