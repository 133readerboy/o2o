package cn.apolloj.o2o.entity;
import java.util.Date;
/**
 *  区域信息
 * @author spark
 * @version 1.0
 * @date 2019/5/1 9:57
 **/
public class Area {
    //共5个属性
    /**
     * ID
     */
    private Integer areaId;
    /**
     * 名称
     */
    private String areaName;
    /**
     * 权重,越大越排前显示
     */
    private Integer priority;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date lastEditTime;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
