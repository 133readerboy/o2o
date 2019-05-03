package cn.apolloj.o2o.service;

import cn.apolloj.o2o.dto.ShopExecution;
import cn.apolloj.o2o.entity.Shop;
import cn.apolloj.o2o.exceptions.ShopOperationException;

import java.io.InputStream;

/**
 * 店铺业务层接口
 * @version 1.0
 * @program: o2o
 * @author: spark
 * @create: 2019-05-03 13:09
 **/
public interface ShopService {

    /**
     * 新增(创建)店铺
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return 业务层封装的dto对象
     * @throws ShopOperationException
     */
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String fileName) throws ShopOperationException;
}
