package pkg0507.p2.n1;

public class HighState extends AbstractState {
    public HighState(AbstractState state) {
        this.stateName=state.getStateName();
    }
    public void writeNote(int score) {
        this.point+=score*2;
    }
    public void downloadFile(int score) {
        this.point-=score/2;
    }
    public void checkState(int score) {

    }

}
