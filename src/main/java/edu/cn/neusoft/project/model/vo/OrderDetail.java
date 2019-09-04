package edu.cn.neusoft.project.model.vo;

public class OrderDetail {
    private int detail_id;
    private int order_id;
    private int goods_id;
    private String detail_name;
    private String detail_size;
    private String detail_color;
    private float detail_price;
    private int detail_num;
    private String detail_pic;
    public OrderDetail(){

    }
    public int getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(int detail_id) {
        this.detail_id = detail_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getDetail_name() {
        return detail_name;
    }

    public void setDetail_name(String detail_name) {
        this.detail_name = detail_name;
    }

    public String getDetail_size() {
        return detail_size;
    }

    public void setDetail_size(String detail_size) {
        this.detail_size = detail_size;
    }

    public String getDetail_color() {
        return detail_color;
    }

    public void setDetail_color(String detail_color) {
        this.detail_color = detail_color;
    }

    public float getDetail_price() {
        return detail_price;
    }

    public void setDetail_price(float detail_price) {
        this.detail_price = detail_price;
    }

    public int getDetail_num() {
        return detail_num;
    }

    public void setDetail_num(int detail_num) {
        this.detail_num = detail_num;
    }

    public String getDetail_pic() {
        return detail_pic;
    }

    public void setDetail_pic(String detail_pic) {
        this.detail_pic = detail_pic;
    }

    public OrderDetail(int detail_id, int order_id, int goods_id, String detail_name, String detail_size, String detail_color, float detail_price, int detail_num, String detail_pic) {
        this.detail_id = detail_id;
        this.order_id = order_id;
        this.goods_id = goods_id;
        this.detail_name = detail_name;
        this.detail_size = detail_size;
        this.detail_color = detail_color;
        this.detail_price = detail_price;
        this.detail_num = detail_num;
        this.detail_pic = detail_pic;
    }




}
