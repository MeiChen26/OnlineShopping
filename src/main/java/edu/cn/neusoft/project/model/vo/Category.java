package edu.cn.neusoft.project.model.vo;

public class Category {
    private int cate_id;
    private String cate_name;
    private String cate_pic;

    public Category(int cate_id, String cate_name, String cate_pic) {
        this.cate_id = cate_id;
        this.cate_name = cate_name;
        this.cate_pic = cate_pic;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public String getCate_pic() {
        return cate_pic;
    }

    public void setCate_pic(String cate_pic) {
        this.cate_pic = cate_pic;
    }
}
