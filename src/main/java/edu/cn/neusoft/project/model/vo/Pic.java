package edu.cn.neusoft.project.model.vo;

public class Pic {
    private int pic_id;
    private int goods_id;
    private String pic_url;

    public void setPic_id(int pic_id) {
        this.pic_id = pic_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public int getPic_id() {
        return pic_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public String getPic_url() {
        return pic_url;
    }

    public Pic(int pic_id, int goods_id, String pic_url) {
        this.pic_id = pic_id;
        this.goods_id = goods_id;
        this.pic_url = pic_url;
    }
    public Pic(){

    }
}
