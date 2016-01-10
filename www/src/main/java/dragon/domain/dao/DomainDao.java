package dragon.domain.dao;

import dragon.domain.model.Domain;
import dragon.framework.datasource.DataSource;

/**
 * 域名dao接口
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2016-01-11 01:04
 */
@DataSource("dragonDataSource")
public interface DomainDao {

    //Logic
    /**
     * 保存域名信息
     *
     * @param domain
     * @return
     */
    int save(Domain domain);

    /**
     * 根据id删除域名信息
     *
     * @param id
     * @return
     */
    int delete(long id);

    /**
     * 根据id查询域名信息
     *
     * @param id
     * @return
     */
    Domain get(long id);

}
