package s18001020707.V1_more.Filter;

import java.util.regex.Pattern;

public class Filter2 implements Filter{

    @Override
    public boolean hasanyMGC(String username) {
        Pattern p =Pattern.compile("¶Ä²©");
        return p.matcher(username).find();
    }


}
