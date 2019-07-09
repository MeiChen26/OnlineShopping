package edu.cn.neusoft.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderAction {

    @RequestMapping("/buyGoods.action")
   public String buyGoods(Map<String, Object>map){
        map.put("address", null);
       return "/order/buyGoods";
    }
}
