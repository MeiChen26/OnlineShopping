package edu.cn.neusoft.project.model.dao;

import edu.cn.neusoft.project.model.vo.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
    List<Goods> findNewGoods();
    List<Goods> findSalesGoods();
    List<Goods> findAllGoodsByCateId(String cateId);



    Goods findGoodsDetailById(String goodsId);
    Goods findGoodsSizeById(String goodsId);
    Goods findGoodsColorById(String goodsId);
}
