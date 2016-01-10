package dragon.framework.datasource;

import java.lang.annotation.*;

/**
 * 数据源注解标识，value为spring容器中配置的dataSource名称，通过在类或方法上注解可指定对应数据源，优先使用方法数据源，若没有则继承类上的数据源。如
 * <p><hr>
 * <blockquote>
 * <pre>
 *     @DataSource("testDataSource1")
 *     public interface TestMapper {
 *
 *          @DataSource("testDataSource2")
 *          int count();
 *
 *          List gets();
 *
 *     }
 *
 * </pre>
 * </blockquote>
 * </p>
 * 以上示例中，count()方法使用“testDataSource2”指定的数据源，gets()方法使用类上数据源"testDataSource1".
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2016-01-10 13:53
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
public @interface DataSource {

    //Logic
    /**
     * 指定数据源名称
     */
    String value();
}
