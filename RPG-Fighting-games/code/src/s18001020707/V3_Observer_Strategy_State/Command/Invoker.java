package s18001020707.V3_Observer_Strategy_State.Command;

public class Invoker {
    private Command slot;

    public void setCommand(Command command){
        slot = command;
    }

    public void buttonWatPressed(String username){
        slot.execute(username);
    }
}
