package cn.apolloj.o2o.entity;

import java.util.Date;

/**
  * 头条信息类
 * @author spark
 * @version 1.0
 * @date 2019/5/1 21:02
 **/
public class HeadLine {
    /**
     * 共有8个属性
     */
    /**
     * 主键ID
     */
    private Long lineId;
    /**
     *头条名字
     */
    private String lineName;
    /**
     * 头条链接，点击头条会进入相应链接中
     */
    private String lineLink;
    /***
     * 头条图片
     */
    private String lineImg;
    /**
     *展示优先级，权重，越大越排前显示
     */
    private Integer priority;
     /**
      * 0.不可用 1.可用
      */
    private Integer enableStatus;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后一次更新时间
     */
    private Date lastEditTime;

    public Long getLineId() {
        return lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getLineLink() {
        return lineLink;
    }

    public void setLineLink(String lineLink) {
        this.lineLink = lineLink;
    }

    public String getLineImg() {
        return lineImg;
    }

    public void setLineImg(String lineImg) {
        this.lineImg = lineImg;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
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

