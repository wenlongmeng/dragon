package dragon.framework.datasource;

import dragon.commons.util.ThreadContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * mybatis拦截器：基于注解的数据源处理
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2016-01-10 13:52
 */
@Intercepts({@Signature(type=Executor.class, method="query", args={MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class}), @Signature(type=Executor.class, method="update", args={MappedStatement.class,Object.class})})
public class DefaultDataSourceInterceptor implements Interceptor {

    //Local variables
    /**
     * 数据源缓存
     */
    private static ConcurrentMap<String, String> dataSourceCache = new ConcurrentHashMap<String, String>();

    /**
     * 设置数据源
     *
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        String dataSource = ThreadContext.get("dataSource");
        if(StringUtils.isBlank(dataSource)){
            //获取数据源
            dataSource = this.getDataSource(invocation);
            if(StringUtils.isNotBlank(dataSource)){
                ThreadContext.put("dataSource", dataSource);
            }
            try{
                //执行方法调用
                return invocation.proceed();
            }finally {
                //释放数据源
                ThreadContext.remove("dataSource");
            }
        }
        return invocation.proceed();
    }

    /**
     * 获取数据源：获取方法上{@link DataSource}注解；无则获取类上{@link DataSource}注解；有则返回；否则返回null
     *
     * @param invocation
     * @return
     */
    private String getDataSource(Invocation invocation) throws Throwable {
        MappedStatement ms = (MappedStatement)invocation.getArgs()[0];
        //从缓存获取数据源
        if(dataSourceCache.containsKey(ms.getId())){
            return dataSourceCache.get(ms.getId());
        }

        //从注解解析数据源
        String className = StringUtils.substringBeforeLast(ms.getId(), ".");
        String methodName = StringUtils.substringAfterLast(ms.getId(), ".");
        //获取方法上DataSource注解
        DataSource dataSource = null;
        Method[] methods = Class.forName(className).getMethods();
        for(Method method : methods){
            if(method.getName().equals(methodName)){
                dataSource = method.getAnnotation(DataSource.class);
            }
        }
        if(dataSource == null){
            //获取类上DataSource注解
            dataSource = Class.forName(className).getAnnotation(DataSource.class);
        }

        String result = dataSource != null ? dataSource.value() : null;

        //缓存数据源
        if(StringUtils.isNotBlank(result)){
            dataSourceCache.putIfAbsent(ms.getId(), result);
        }

        return result;
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o,this);
    }

    @Override
    public void setProperties(Properties properties) {
    }
}
