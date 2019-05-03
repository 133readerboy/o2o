package cn.apolloj.o2o.enums;

public enum ShopStateEnum {
    CHECK(1,"审核中")
    ,OFFLINE(-1,"非法店铺")
    ,SUCCESS(1,"操作成功")
    ,PASS(2,"通过认证")
    ,INNER_ERROR(-1001,"内部系统错误")
    ,NULL_SHOPID(-1002,"shopId为空")
    ,NULL_SHOP(-1003,"shop信息为空")
    ,NULL_AREA(-1004,"店铺地域信息为空")
    ,UNKNOW_OWNER(-1005,"店铺所有者未知")
    ,UNKNOW_SHOP_CATEGORY(-1006,"店铺类型未知")
    ;

    private Integer state;
    private String stateInfo;

    /**
     * 私有化构造器，此处为单例
     * @param state
     * @param stateInfo
     */
    private ShopStateEnum(Integer state,String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static ShopStateEnum stateOf(int state){
        for (ShopStateEnum stateEnum : values()){
            if (stateEnum.getState() == state) {
                return stateEnum;
            }
        }
        return null;
    }

    public Integer getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
