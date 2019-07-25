package edu.cn.neusoft.project.model.service;

import edu.cn.neusoft.project.model.dao.GoodsMapper;
import edu.cn.neusoft.project.model.vo.Goods;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImp implements GoodsService{

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getNewGoods() {
        return goodsMapper.findNewGoods();
    }

    @Override
    public List<Goods> getSalesGoods(){ return goodsMapper.findSalesGoods();}

    @Override
    public List<Goods> getGoodsByCate(String cateId) {
        List<Goods> goods = goodsMapper.findAllGoodsByCateId(cateId);
        return goods;

    }

    @Override
    public Goods getGoodsDetailById(String goodsId) {
        Goods goodsDetail = goodsMapper.findGoodsDetailById(goodsId);
        return goodsDetail;
    }

    @Override
    public Goods getGoodsSizeById(String goodsId) {
        Goods goodsSize = goodsMapper.findGoodsSizeById(goodsId);
        return goodsSize;
    }

    @Override
    public Goods getGoodsColorById(String goodsId) {
        Goods goodsColor = goodsMapper.findGoodsColorById(goodsId);
        return goodsColor;
    }

}
