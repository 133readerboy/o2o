package cn.apolloj.o2o.dao;

import cn.apolloj.o2o.entity.Shop;
import org.springframework.dao.DataAccessException;

/**
 * 店铺持久层接口
 * @version 1.0
 * @program: o2o
 * @author: spark
 * @create: 2019-05-02 21:42
 **/
public interface ShopDao {
    /**
     * 新增店铺
     * @param shop
     * @return 成功返回1 失败返回-1
     */
    int insertShop(Shop shop) throws DataAccessException;

    /**
     * 更新店铺信息
     * @param shop
     * @return 成功返回1 失败返回-1
     */
    int updateShop(Shop shop) throws DataAccessException;
}
