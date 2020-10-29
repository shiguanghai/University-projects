package pkg0407.n1;

public class Test {
    public static void main(String[] args) {
        CompanyArmy san = new CompanyArmy();
        Command command = new ConcreteCommand(san);
        ArmySupervisor zhihui = new ArmySupervisor();
        zhihui.setCommand(command);
        zhihui.starExecuteCommand();
    }
}
