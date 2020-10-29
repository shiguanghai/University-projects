package pkg0507.p2.n2;

public class RedState implements State {
    private Bank bank;
    public RedState(Bank bank) {
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
        if(bank.balance<0&&bank.balance>=-1000) {
            bank.state = bank.YellowState;
            System.out.println("******�˻�״̬���Ϊ��ɫ******");
        }
    }

    @Override
    public void withdraw(double money) {
        System.out.println("******�˻�״̬Ϊ��ɫ******");
        System.out.println("******����ǰ����ȡ��******");
        System.out.println("******������Ϊ��"+bank.balance+" ******");
    }

}
