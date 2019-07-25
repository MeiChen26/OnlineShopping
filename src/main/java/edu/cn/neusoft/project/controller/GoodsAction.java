package edu.cn.neusoft.project.controller;

import edu.cn.neusoft.project.model.service.GoodsService;
import edu.cn.neusoft.project.model.vo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goods")
public class GoodsAction {

    @Resource
    private GoodsService goodsService;

    @RequestMapping("/getGoodsByCategory.action")
    public String getGoodsByCate(@RequestParam String cateId, Map<String, List<Goods>> map){
        List<Goods> goods = goodsService.getGoodsByCate(cateId);
        map.put("goods", goods);
        return "/goods/goodsList";
    }

    @RequestMapping("/getGoodsDetailById.action")
    public String getGoodsDetailById(@RequestParam String goodsId, Map<String, Goods>map){

        Goods goodsDetail = goodsService.getGoodsDetailById(goodsId);
        Goods goodsSizes = goodsService.getGoodsSizeById(goodsId);
        Goods goodsColors=goodsService.getGoodsColorById(goodsId);
        map.put("goodsDetail", goodsDetail);
        map.put("goodsSizes", goodsSizes);
        map.put("goodsColors", goodsColors);
        return "/goods/goodsDetail";
    }
}
