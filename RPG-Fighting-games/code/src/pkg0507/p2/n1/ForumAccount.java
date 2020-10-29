package pkg0507.p2.n1;

public class ForumAccount {
    private AbstractState state;
    private String name;
    public ForumAccount(String name) {
        super();
        this.name = name;
    }
    public void setState(AbstractState state) {
        this.state = state;
    }
    public AbstractState getState() {
        return state;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void downloadFile(int score) {
        state.downloadFile(score);
    }
    public void writeNote(int score) {
        state.writeNote(score);
    }
    public void replyNote(int score) {
        state.replyNote(score);
    }

}
