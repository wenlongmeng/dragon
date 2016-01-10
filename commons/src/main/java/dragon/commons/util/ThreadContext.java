package dragon.commons.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 线程上线文，基于{@link ThreadLocal}实现
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2016-01-10 13:56
 */
public class ThreadContext {

    //Local variables
    private static ThreadLocal threadLocal = new ThreadLocal();

    //Logic
    /**
     * 存储key/value信息
     *
     * @param key
     * @param v
     */
    public static <T> void put(String key, T v){
        Map m = (Map)threadLocal.get();
        if(m == null){
            m = new HashMap();
            threadLocal.set(m);
        }
        m.put(key, v);
    }

    /**
     * 获取key对应的值
     *
     * @param key
     * @param <T>
     * @return
     */
    public static <T> T get(String key){
        Map m = (Map)threadLocal.get();
        return m != null ? (T)m.get(key) : null;
    }

    /**
     * 移除指定键值对
     *
     * @param key
     */
    public static void remove(String key){
        Map m = (Map)threadLocal.get();
        if(m != null){
            m.remove(key);
        }
    }

    /**
     * 清除
     */
    public static void clear(){
        threadLocal.remove();
    }

}
