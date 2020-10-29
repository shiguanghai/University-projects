package pkg0507.p2.n2;

public class GreenState implements State {
    private Bank bank;
    public GreenState(Bank bank) {
        super();
        this.bank = bank;
    }

    @Override
    public void deposit(double money) {
        System.out.println("******账户状态为绿色******");
        bank.balance+=money;
        System.out.println("******存入金额为："+money+" ******");
        System.out.println("******你的余额为："+bank.balance+" ******");


    }

    @Override
    public void withdraw(double money) {
        System.out.println("******账户状态为绿色******");
        bank.balance-=money;
        System.out.println("******取出金额为："+money+" ******");
        System.out.println("******你的余额为："+bank.balance+" ******");
        if(bank.balance<0&&bank.balance>=-1000) {
            bank.state = bank.YellowState;
            System.out.println("******账户状态变更为黄色******");
        }
        if(bank.balance<-1000) {
            bank.state=bank.RedState;
            System.out.println("******账户状态变更为红色******");
        }
    }

}
