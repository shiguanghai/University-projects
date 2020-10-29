package pkg0507.p2.n2;

public class GreenState implements State {
    private Bank bank;
    public GreenState(Bank bank) {
        super();
        this.bank = bank;
    }

    @Override
    public void deposit(double money) {
        System.out.println("******�˻�״̬Ϊ��ɫ******");
        bank.balance+=money;
        System.out.println("******������Ϊ��"+money+" ******");
        System.out.println("******������Ϊ��"+bank.balance+" ******");


    }

    @Override
    public void withdraw(double money) {
        System.out.println("******�˻�״̬Ϊ��ɫ******");
        bank.balance-=money;
        System.out.println("******ȡ�����Ϊ��"+money+" ******");
        System.out.println("******������Ϊ��"+bank.balance+" ******");
        if(bank.balance<0&&bank.balance>=-1000) {
            bank.state = bank.YellowState;
            System.out.println("******�˻�״̬���Ϊ��ɫ******");
        }
        if(bank.balance<-1000) {
            bank.state=bank.RedState;
            System.out.println("******�˻�״̬���Ϊ��ɫ******");
        }
    }

}
