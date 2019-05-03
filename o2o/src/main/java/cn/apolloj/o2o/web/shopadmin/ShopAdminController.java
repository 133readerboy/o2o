package cn.apolloj.o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 负责转发路由到shopoperation.html
 * @author spark
 * @version 1.0
 * @date 2019/5/3 21:02
 **/
@RequestMapping(value = "/shopadmin",method = {RequestMethod.GET})
@Controller
public class ShopAdminController {
    @RequestMapping(value = "/shopoperation")
    public String shopOperation(){
        return "shop/shopoperation";
    }

}
