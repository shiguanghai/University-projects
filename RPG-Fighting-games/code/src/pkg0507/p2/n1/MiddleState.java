package pkg0507.p2.n1;

public class MiddleState extends AbstractState {
    public MiddleState(AbstractState state) {
        this.stateName=state.getStateName();
    }
    public void writeNote(int score) {
        this.point+=score*2;
    }
    public void checkState(int score) {
    }

}
