package cn.apolloj.o2o.dto;

import cn.apolloj.o2o.entity.Shop;
import cn.apolloj.o2o.enums.ShopStateEnum;

import java.util.List;

/**
 * 店铺状态对象
 * @author spark
 * @version 1.0
 * @date 2019/5/3 12:45
 **/
public class ShopExecution {
    /**
     * 结果状态
     */
    private Integer state;
    /**
     * 状态标识
     */
    private String stateInfo;
    /**
     * 店铺数量
     */
    private Integer count;
    /**
     * 操作的shop(增删改店铺时使用)
     */
    private Shop shop;
    /**
     * shop列表(查询店铺列表时使用|批量插入店铺时使用)
     */
    private List<Shop> shopList;

    public ShopExecution() { }

    /**
     * 店铺操作失败时使用的构造器
     * @param shopStateEnum
     */
    public ShopExecution(ShopStateEnum shopStateEnum) {
        this.state = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStateInfo();
    }

    /**
     * 店铺操作成功时使用的构造器 返回shop
     * @param shopStateEnum
     */
    public ShopExecution(ShopStateEnum shopStateEnum,Shop shop) {
        this.state = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStateInfo();
        this.shop = shop;
    }

    /**
     * 店铺操作成功时使用的构造器 返回shopList
     * @param shopStateEnum
     */
    public ShopExecution(ShopStateEnum shopStateEnum , List<Shop> shopList) {
        this.state = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStateInfo();
        this.shopList = shopList;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }
}
