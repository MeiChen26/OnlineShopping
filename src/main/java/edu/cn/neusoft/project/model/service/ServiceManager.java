package edu.cn.neusoft.project.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceManager {

    @Autowired
    private CateService cateService;
    @Autowired
    private GoodsService goodsService;

    public CateService getCateService(){
        return cateService;
    }
    public GoodsService getGoodsService() {
        return goodsService;
    }

}
