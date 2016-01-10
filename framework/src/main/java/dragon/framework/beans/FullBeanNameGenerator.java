package dragon.framework.beans;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

/**
 * 全路径bean名称，避免不同包内同名
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2016-01-10 13:54
 */
public class FullBeanNameGenerator implements BeanNameGenerator {

    //Local variables

    //Logic

    /**
     * Generate a bean name for the given bean definition.
     *
     * @param definition the bean definition to generate a name for
     * @param registry   the bean definition registry that the given definition
     *                   is supposed to be registered with
     * @return the generated bean name
     */
    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        return definition.getBeanClassName();
    }
}
