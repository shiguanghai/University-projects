package pkg0407.n2;

public class RequestMakeDir {
    Command command;
    public void setCommand(Command command){
        this.command=command;
    }
    public void startExecuteCommand(String name){
        command.execute(name);
    }
    public void undoCommand(){
        command.undo();
    }
}
