package edu.cn.neusoft.project.model.dao;

import edu.cn.neusoft.project.model.vo.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CateMapper {

    List<Category> findAllCategory();
}
