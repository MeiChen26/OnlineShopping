package edu.cn.neusoft.project.model.service;

import edu.cn.neusoft.project.model.vo.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> getNewGoods();
    List<Goods> getSalesGoods();
    List<Goods> getGoodsByCate(String cateId);
    Goods getGoodsDetailById(String goodsId);
    Goods getGoodsSizeById(String goodsId);
    Goods getGoodsColorById(String goodsId);
}
