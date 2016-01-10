package dragon.commons.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2016-01-10 12:18
 */
public class DateUtil {

    //Local variables
    /**
     * 日期格式：默认格式
     */
    public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

    //Logic

    /**
     * 格式化日期:默认格式{@link #YYYYMMDDHHMMSS}
     *
     * @param date
     * @return
     */
    public static String format(Date date){
        return format(date, YYYYMMDDHHMMSS);
    }


    /**
     * 按照指定格式格式化日期
     *
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format){
        return new SimpleDateFormat(format).format(date);
    }

}
