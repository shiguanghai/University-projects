package pkg0507.p2.n1;

public class PrimaryState extends AbstractState {
    public PrimaryState(AbstractState state) {
        this.stateName=state.getStateName();
    }
    public PrimaryState(ForumAccount account) {
        this.stateName=account.getName();
    }
    public void downloadFile(int score) {
        System.out.println("²»ÄÜÏÂÔØ");
    }
    public void checkState(int score) {
    }

}
