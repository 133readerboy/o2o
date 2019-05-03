package cn.apolloj.o2o.web.superadmin;

import cn.apolloj.o2o.entity.Area;
import cn.apolloj.o2o.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 超级管理员视图层
 * @author spark
 * @version 1.0
 * @date 2019/5/2 14:55
 **/
@Controller
@RequestMapping("/superadmin")
public class AreaController {
    /** logger */
    private static final Logger log = LoggerFactory.getLogger(AreaController.class);
    private final AreaService areaServiceImpl;
    @Autowired
    public AreaController(AreaService areaServiceImpl) {
        this.areaServiceImpl = areaServiceImpl;
    }

    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> listArea(){
        log.info("listArea()============start==========");
        long startTime = System.nanoTime();
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<Area> list = Collections.emptyList();
        try {
            list = this.areaServiceImpl.getAreaList();
                //EasyUI 分页控件 rows 集合 total 总数
            modelMap.put("rows",list);
            modelMap.put("total",list.size());

        }catch (Exception e){
            log.error(e.toString());
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        long endTime=System.nanoTime();
        log.info("costTime:[{}ms]",endTime-startTime);
        log.info("listArea()============stop===========");
        return modelMap;
    }
}
