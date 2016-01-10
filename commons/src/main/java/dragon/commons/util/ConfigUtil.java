package dragon.commons.util;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 资源文件工具类
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2016-01-10 13:57
 */
public class ConfigUtil {

    //Local variables
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ConfigUtil.class);
    /**
     * 配置信息缓存
     */
    private static Map<String, Configuration> configurations = new HashMap<String, Configuration>();


    //Logic

    /**
     * 加载配置文件
     *
     * @param path
     * @return
     */
    public static Configuration load(String path) {
        if(!configurations.containsKey(path)){
            synchronized (ConfigUtil.class){
                if(!configurations.containsKey(path)){
                    configurations.put(path, loadFromDisk(path));
                }
            }
        }
        return configurations.get(path);
    }

    /**
     * 从硬盘加载指定文件
     *
     * @param path 文件路径
     * @return
     */
    private static Configuration loadFromDisk(String path){
        PropertiesConfiguration configuration = null;
        try {
            configuration = new PropertiesConfiguration();
            configuration.setEncoding("utf8");
            configuration.load(path);
            configuration.setReloadingStrategy(new FileChangedReloadingStrategy());
        } catch (Throwable e) {
            logger.error("load({})", path, e);
            throw new RuntimeException("load(" + path + ")", e);
        }

        return configuration;
    }

}
