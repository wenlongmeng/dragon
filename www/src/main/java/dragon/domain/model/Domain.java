package dragon.domain.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 域名信息
 *
 * @author Wenlong Meng(wenlong.meng@gmail.com)
 * @version 1.0 at 2016-01-11 01:01
 */
public class Domain implements Serializable {
    private static final long serialVersionUID = -7391098501787220705L;

    //Local variables
    /**
     * pk
     */
    private long id;
    /**
     * 域名
     */
    private String domain;
    /**
     * 状态：1-可用；0-待确认；-1-不可用
     */
    private int status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    //Logic


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Domain{" +
                "id=" + id +
                ", domain='" + domain + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
