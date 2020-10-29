package pkg0407.n2;

import java.util.ArrayList;

public class ConcreteCommand implements Command {
    ArrayList<String> dirNameList;
    MakeDir makeDir;
    public ConcreteCommand(MakeDir makeDir){
        dirNameList = new ArrayList<String>();
        this.makeDir=makeDir;
    }
    public void execute(String name){
        makeDir.createDir(name);
        dirNameList.add(name);
    }
    public void undo(){
        if(dirNameList.size()>0){
            makeDir.deleteDir(dirNameList.get(dirNameList.size()-1));
            dirNameList.remove(dirNameList.size()-1);
        }else {
            System.out.println("没有需要撤销的操作！");
        }
    }
}
