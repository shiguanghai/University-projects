package pkg0407.n2;

import java.io.File;

public class MakeDir {
    //创建目录
    public void createDir(String name){
        File dir = new File(name);
        dir.mkdir();
    }
    //删除目录
    public void deleteDir(String name){
        File dir = new File(name);
        dir.delete();
    }
}
