package cn.apolloj.o2o.service;

import cn.apolloj.o2o.entity.Area;

import java.util.List;

/**
 * Area业务层接口
 * @version 1.0
 * @program: o2o
 * @author: spark
 * @create: 2019-05-02 14:38
 **/
public interface AreaService {
    /**
     * 获取Area对象集合
     * @return areaList
     */
    List<Area> getAreaList();
}
