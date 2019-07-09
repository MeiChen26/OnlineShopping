package edu.cn.neusoft.project.model.service;

import edu.cn.neusoft.project.model.dao.CateMapper;
import edu.cn.neusoft.project.model.vo.Category;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CateServiceImp implements CateService{

    @Resource
    private CateMapper cateMapper;

    @Override
    public List<Category> getAllCategory() {
        List<Category> cates=cateMapper.findAllCategory();
        return cates;

    }
}
