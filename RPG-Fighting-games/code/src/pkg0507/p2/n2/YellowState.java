package pkg0507.p2.n2;

public class YellowState implements State {
    private Bank bank;
    public YellowState(Bank bank) {
        super();
        this.bank = bank;
    }
    @Override
    public void deposit(double money) {
        System.out.println("******�˻�״̬Ϊ��ɫ******");
        bank.balance+=money;
        System.out.println("******������Ϊ��"+money+" ******");
        System.out.println("******������Ϊ��"+bank.balance+" ******");
        if(bank.balance>=0) {
            bank.state=bank.GreenState;
            System.out.println("******�˻�״̬���Ϊ��ɫ******");
        }
    }

    @Override
    public void withdraw(double money) {
        System.out.println("******�˻�״̬Ϊ��ɫ******");
        bank.balance-=money;
        System.out.println("******ȡ�����Ϊ��"+money+" ******");
        System.out.println("******������Ϊ��"+bank.balance+" ******");
        if(bank.balance<-1000) {
            bank.state=bank.RedState;
            System.out.println("******�˻�״̬���Ϊ��ɫ******");
        }
    }

}
