package dragon.domain.controller;

import dragon.domain.service.DomainService;
import dragon.test.BaseTester;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * 域名服务测试
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2016-01-11 02:34
 */
public class DomainControllerTest extends BaseTester {

    //Local variables
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(DomainControllerTest.class);
    /**
     * controller
     */
    @Resource
    private DomainController controller;

    //Logic
    @Test
    public void get(){
        logger.info("result: {}", this.controller.getById(1));
    }

}
