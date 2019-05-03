package cn.apolloj.o2o.service.impl;

import cn.apolloj.o2o.dao.ShopDao;
import cn.apolloj.o2o.dto.ShopExecution;
import cn.apolloj.o2o.entity.Shop;
import cn.apolloj.o2o.enums.ShopStateEnum;
import cn.apolloj.o2o.exceptions.ShopOperationException;
import cn.apolloj.o2o.service.ShopService;
import cn.apolloj.o2o.util.ImageUtil;
import cn.apolloj.o2o.util.PathUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.Date;

/**
 * @author spark
 * @version 1.0
 * @date 2019/5/3 13:11
 **/
@Service
public class ShopServiceImpl implements ShopService {
    /** logger */
    private static final Logger log = LoggerFactory.getLogger(ShopServiceImpl.class);
    @Autowired
    private ShopDao shopDao;

    /**
     * 新增(创建)店铺
     *
     * @param shop
     * @param shopImgInputStream
     * @return 业务层封装的dto对象
     */
    @Override
    @Transactional(rollbackFor = ShopOperationException.class)
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String fileName) throws ShopOperationException{
        //空值判断
        if(isShoplegality(shop) instanceof Boolean){
            //通过shop非空验证
            //进行具体新增店铺逻辑
            try {
                //1.初始化必要参数，给店铺信息赋值
                //审核中
                shop.setEnableStatus(0);
                shop.setCreateTime(new Date());
                shop.setLastEditTime(new Date());
                //添加店铺信息
                int effectedNum = shopDao.insertShop(shop);
                if (effectedNum <= 0) {
                    log.info("店铺创建失败");
                    throw new ShopOperationException("店铺创建失败");
                }else {
                    if (shopImgInputStream != null && !shopImgInputStream.equals("")) {
                        //存储图片
                        try {
                            addShopImg(shop, shopImgInputStream,fileName);
                        }catch (Exception e){
                            log.info("addShopImg error: " + e.getMessage());
                            throw new ShopOperationException("addShopImg error: " + e.getMessage());
                        }
                        //更新店铺的图片地址
                        effectedNum = shopDao.updateShop(shop);
                        if (effectedNum <= 0) {
                            log.info("updateShopImg error");
                            throw new ShopOperationException("updateShopImg error");
                        }
                    }
                }

            }catch (Exception e){
                log.info("addShop error: "+e.getMessage());
                //此处所不做任何处理，则spring无法回滚事务
                // 有两种解决方案：1.此处手动抛出RuntimeException(默认只拦截运行时异常)
                throw new ShopOperationException("addShop error: "+e.getMessage());
                //2.手动回滚事务(推荐)
                //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }


        }


        //新增成功
        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }

    /**
     * 将图片路径值存储到shop中
     *      * @param shop
     *      * @param shopImg
     * @param shop 店铺对象
     * @param shopImgInputStream 店铺图片输入流
     * @param fileName
     */
    private void addShopImg(Shop shop, InputStream shopImgInputStream, String fileName) {
        //获取shop图片目录的相对值路径
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        //存储图片，返回相对值路径-->将其放入数据库
        String shopImgAddr = ImageUtil.generateThumbnails(shopImgInputStream,fileName, dest);
        shop.setShopImg(shopImgAddr);
    }

    /**
     * 校验传入的shop对象是否为null
     * 以及其所属地区Area|所有者PersonInfo(owner)|所属类别shopCateg
     * 是否为null
     * @param shop
     * @return
     */
    private Object isShoplegality(Shop shop) {
        if (shop == null && shop.equals("")) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }else{
            if (shop.getArea() == null && shop.getArea().equals("")) {
                return new ShopExecution(ShopStateEnum.NULL_AREA);
            }
            if (shop.getOwner() == null && shop.getOwner().equals("")){
                return new ShopExecution(ShopStateEnum.UNKNOW_OWNER);
            }
            if (shop.getShopCategory() == null && shop.getShopCategory().equals("")) {
                return new ShopExecution(ShopStateEnum.UNKNOW_SHOP_CATEGORY);
            }
        }
        return true;
    }

}
