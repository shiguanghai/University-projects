package pkg0507.p2.n1;

public abstract class AbstractState {
    protected int point;
    protected String stateName;
    private ForumAccount acc;
    public void checkState(int score) {
    }
    public void downloadFile(int score) {
        this.point-=score;
    }
    public void writeNote(int score) {
        this.point+=score;
    }
    public void replyNote(int score) {
        this.point+=score;
    }
    public void setPoint(int point) {
        this.point = point;
    }
    public int getPoint() {
        return point;
    }
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    public String getStateName() {
        return stateName;
    }

}
