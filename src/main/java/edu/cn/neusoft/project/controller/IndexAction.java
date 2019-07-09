package edu.cn.neusoft.project.controller;

import edu.cn.neusoft.project.model.service.CateServiceImp;
import edu.cn.neusoft.project.model.service.ServiceManager;
import edu.cn.neusoft.project.model.vo.Category;
import edu.cn.neusoft.project.model.vo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexAction {

    @Resource
    private ServiceManager serviceManger;

    @RequestMapping("index.action")
    public ModelAndView getIndexPage(){
        ModelAndView mav = new ModelAndView();
        List<Category> categories = serviceManger.getCateService().getAllCategory();
        List<Goods> newGoods = serviceManger.getGoodsService().getNewGoods();
        List<Goods> salesGoods = serviceManger.getGoodsService().getSalesGoods();


        mav.addObject("categories", categories);
        mav.addObject("newGoods", newGoods);
        mav.addObject("salesGoods", salesGoods);
        mav.setViewName("home");
        return mav;

//        m.put("categories", categories);
//        return "home";
    }

}
