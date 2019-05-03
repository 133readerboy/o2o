package cn.apolloj.o2o.dao;

import cn.apolloj.o2o.entity.Area;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * Area区域dao层接口
 * @version 1.0
 * @program: o2o
 * @author: spark
 * @create: 2019-05-02 14:02
 **/
public interface AreaDao {
    /**
     * 列出区域列表
     * @return areaList
     */
    List<Area> queryArea() throws DataAccessException;
}
