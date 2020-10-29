package s18001020707.V1_more.Command;

public class Invoker {
    private Command slot;

    public void setCommand(Command command){
        slot = command;
    }

    public void buttonWatPressed(String username){
        slot.execute(username);
    }
}
