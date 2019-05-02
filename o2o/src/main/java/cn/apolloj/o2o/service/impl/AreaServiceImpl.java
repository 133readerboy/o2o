package cn.apolloj.o2o.service.impl;

import cn.apolloj.o2o.dao.AreaDao;
import cn.apolloj.o2o.entity.Area;
import cn.apolloj.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author spark
 * @version 1.0
 * @date 2019/5/2 14:40
 **/
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    /**
     * 获取Area对象集合
     *
     * @return areaList
     */
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
