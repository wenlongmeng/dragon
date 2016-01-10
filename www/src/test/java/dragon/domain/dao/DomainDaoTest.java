package dragon.domain.dao;

import dragon.test.BaseTester;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * 域名测试
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2016-01-11 01:41
 */
public class DomainDaoTest extends BaseTester {

    //Local variables
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(DomainDaoTest.class);
    /**
     * dao接口
     */
    @Resource
    private DomainDao dao;

    //Logic
    @Test
    public void get(){
        logger.info("result: {}", this.dao.get(1));
    }

}
