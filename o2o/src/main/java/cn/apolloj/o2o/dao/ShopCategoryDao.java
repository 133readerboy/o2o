package cn.apolloj.o2o.dao;

import cn.apolloj.o2o.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * 店铺类别持久层接口
 * @version 1.0
 * @program: o2o
 * @author: spark
 * @create: 2019-05-03 22:21
 **/
public interface ShopCategoryDao {
    List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition")ShopCategory shopCategoryCondition) throws DataAccessException;

}
