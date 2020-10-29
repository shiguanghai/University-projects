package pkg0507.p2.n2;

public class Bank {

        final State GreenState = new GreenState(this);
        final State YellowState = new YellowState(this);
        final State RedState = new RedState(this);

        State state = GreenState;
        double balance = 0;
        public Bank(double money) {
            this.balance=money;
            state=GreenState;
        }
        public void deposit(double money) {
            state.deposit(money);
        }
        public void withdraw(double money) {
            state.withdraw(money);
        }

    }
