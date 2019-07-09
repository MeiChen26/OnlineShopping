package edu.cn.neusoft.project.controller;

import edu.cn.neusoft.project.model.service.CateService;
import edu.cn.neusoft.project.model.vo.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/category/")
public class CategoryAction {

    @Resource
    private CateService cateService;


    @RequestMapping("getAllCategory.action")
    @ResponseBody
    public Map<String,List<Category>> getAllCategory(){
        Map<String,List<Category>> map=new HashMap<String, List<Category>>();
        List<Category> categories = cateService.getAllCategory();
        map.put("categories",categories);

        return map;
    }

}
