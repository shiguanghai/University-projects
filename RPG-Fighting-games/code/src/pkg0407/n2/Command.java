package pkg0407.n2;

public interface Command {
    void execute(String name);
    void undo();//带有撤销操作
}
