package s18001020707.V1_more.Filter;

import java.util.regex.Pattern;

public class Filter1 implements Filter{


    @Override
    public boolean hasanyMGC(String username) {
        Pattern p =Pattern.compile("敏感");
        return p.matcher(username).find();
    }

    public static void main(String args[]){
        Filter1 c=new Filter1();
        System.out.println(c.hasanyMGC("敏感词系统"));
    }

}
