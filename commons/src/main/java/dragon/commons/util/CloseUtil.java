package dragon.commons.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * 释放资源
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2016-01-10 12:40
 */
public class CloseUtil {

    //Local variables

    //Logic

    /**
     * 释放资源
     *
     * @param cs
     */
    public static void close(Closeable... cs) {
        for(Closeable c : cs){
            try {
                if(c != null){
                    c.close();
                }
            } catch (IOException e) {
                //do nothing
            }
        }
    }

}
