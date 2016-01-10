package dragon.domain.controller;

import dragon.domain.model.Domain;
import dragon.domain.service.DomainService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 域名表现层
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2016-01-11 02:43
 */
@Controller
@RequestMapping("/domain")
public class DomainController {

    //Local variables
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(DomainController.class);
    /**
     * 服务
     */
    @Resource
    private DomainService service;

    //Logic
    @RequestMapping("/{id}")
    public Domain getById(long id){
        Domain result = this.service.get(id);
        return result;
    }

}
