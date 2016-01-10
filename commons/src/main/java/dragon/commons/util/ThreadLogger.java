package dragon.commons.util;

import org.slf4j.Logger;

import java.util.Stack;

/**
 * 基于线程的日志
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2016-01-10 13:55
 */
public class ThreadLogger {

    //Local variables
    private static final String DEFAULT_LOGGER_FLAG = "_$Loggers";

    //Logic

    /**
     * add logger
     *
     * @param logger
     */
    public static void push(Logger... logger) {
        Stack<Logger> loggers = ThreadContext.get(DEFAULT_LOGGER_FLAG);
        if(loggers == null){
            loggers = new Stack<Logger>();
            ThreadContext.put(DEFAULT_LOGGER_FLAG, loggers);
        }
        for(Logger _logger : logger){
            if(_logger == null){
                continue;
            }
            loggers.push(_logger);
        }
    }

    /**
     * 输出info级别日志
     *
     * @param format
     * @param args
     */
    public static void info(String format, Object... args){
        Stack<Logger> loggers = ThreadContext.get(DEFAULT_LOGGER_FLAG);
        if(loggers != null){
            for(Logger logger : loggers){
                logger.info(format, args);
            }
        }
    }

    /**
     * 输出error级别日志
     *
     * @param format
     * @param args
     */
    public static void error(String format, Object... args){
        Stack<Logger> loggers = ThreadContext.get(DEFAULT_LOGGER_FLAG);
        if(loggers != null){
            for(Logger logger : loggers){
                logger.error(format, args);
            }
        }
    }

    /**
     * 输出warn级别日志
     *
     * @param format
     * @param args
     */
    public static void warn(String format, Object... args){
        Stack<Logger> loggers = ThreadContext.get(DEFAULT_LOGGER_FLAG);
        if(loggers != null){
            for(Logger logger : loggers){
                logger.warn(format, args);
            }
        }
    }

    /**
     * 移除logger
     */
    public static void pop(){
        Stack<Logger> loggers = ThreadContext.get(DEFAULT_LOGGER_FLAG);
        if(loggers != null){
            loggers.pop();
        }
    }

    /**
     * 清空logger
     */
    public static void clear(){
        Stack<Logger> loggers = ThreadContext.get(DEFAULT_LOGGER_FLAG);
        if(loggers != null){
            loggers.clear();
        }
        ThreadContext.remove(DEFAULT_LOGGER_FLAG);
    }

}
