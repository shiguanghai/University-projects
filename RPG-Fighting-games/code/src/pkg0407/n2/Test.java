package pkg0407.n2;

public class Test {
    public static void main(String[] args) {
        MakeDir makeDir = new MakeDir();
        Command command = new ConcreteCommand(makeDir);
        RequestMakeDir request = new RequestMakeDir();
        request.setCommand(command);
        request.startExecuteCommand("C:\\commandfoder1");
        request.undoCommand();
        request.startExecuteCommand("C:\\commandfoder2");
    }
}
