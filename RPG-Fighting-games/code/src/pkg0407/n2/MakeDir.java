package pkg0407.n2;

import java.io.File;

public class MakeDir {
    //����Ŀ¼
    public void createDir(String name){
        File dir = new File(name);
        dir.mkdir();
    }
    //ɾ��Ŀ¼
    public void deleteDir(String name){
        File dir = new File(name);
        dir.delete();
    }
}
