package dragon.domain.service.impl;

import dragon.domain.dao.DomainDao;
import dragon.domain.model.Domain;
import dragon.domain.service.DomainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 域名服务实现类
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2016-01-11 02:31
 */
@Service
public class DomainServiceImpl implements DomainService {

    //Local variables
    /**
     * dao
     */
    @Resource
    private DomainDao dao;

    //Logic

    /**
     * 保存域名信息
     *
     * @param domain
     * @return
     */
    @Override
    public int save(Domain domain) {
        return this.dao.save(domain);
    }

    /**
     * 根据id删除域名信息
     *
     * @param id
     * @return
     */
    @Override
    public int delete(long id) {
        return this.dao.delete(id);
    }

    /**
     * 根据id查询域名信息
     *
     * @param id
     * @return
     */
    @Override
    public Domain get(long id) {
        return this.dao.get(id);
    }
}
