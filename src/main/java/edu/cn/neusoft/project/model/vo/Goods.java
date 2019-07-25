package edu.cn.neusoft.project.model.vo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;
import java.util.List;

public class Goods {
    private int goods_id;
    private int cate_id;
    private String goods_name;
    private String goods_desc;
    @NumberFormat(pattern="##.#")
    private float goods_price;

    private float goods_discount;
    private int goods_stock;
    private String goods_origin;
    private String goods_material;
    private int goods_postalfee;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date goods_date;
    private String goods_pic;
    private int goods_sale;

    private List<Pic> pics;
    private List<Size> sizes;
    private List<Color> colors;

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public List<Size> getSizes() {
        return sizes;
    }

    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }

    public Goods(int goods_id, int cate_id, String goods_name, String goods_desc, float goods_price, float goods_discount, int goods_stock, String goods_origin, String goods_material, int goods_postalfee, Date goods_date, String goods_pic, int goods_sale, List<Pic> pics, List<Size> sizes, List<Color> colors) {
        this.goods_id = goods_id;
        this.cate_id = cate_id;
        this.goods_name = goods_name;
        this.goods_desc = goods_desc;
        this.goods_price = goods_price;
        this.goods_discount = goods_discount;
        this.goods_stock = goods_stock;
        this.goods_origin = goods_origin;
        this.goods_material = goods_material;
        this.goods_postalfee = goods_postalfee;
        this.goods_date = goods_date;
        this.goods_pic = goods_pic;
        this.goods_sale = goods_sale;
        this.pics = pics;
        this.sizes = sizes;
        this.colors = colors;
    }

    public Goods(int goods_id, int cate_id, String goods_name, String goods_desc, float goods_price, float goods_discount, int goods_stock, String goods_origin, String goods_material, int goods_postalfee, Date goods_date, String goods_pic, int goods_sale, List<Size> sizes) {
        this.goods_id = goods_id;
        this.cate_id = cate_id;
        this.goods_name = goods_name;
        this.goods_desc = goods_desc;
        this.goods_price = goods_price;
        this.goods_discount = goods_discount;
        this.goods_stock = goods_stock;
        this.goods_origin = goods_origin;
        this.goods_material = goods_material;
        this.goods_postalfee = goods_postalfee;
        this.goods_date = goods_date;
        this.goods_pic = goods_pic;
        this.goods_sale = goods_sale;
        this.sizes = sizes;
    }

    public Goods() {

    }

    public List<Pic> getPics(){
        return pics;
    }
    public void setPics(List<Pic> pics){
        this.pics = pics;
    }
    public int getGoods_sale(){
        return goods_sale;}
    public void setGoods_sale(int goods_sale){
        this.goods_sale = goods_sale;
    }
    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_desc() {
        return goods_desc;
    }

    public void setGoods_desc(String goods_desc) {
        this.goods_desc = goods_desc;
    }

    public float getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(float goods_price) {
        this.goods_price = goods_price;
    }

    public float getGoods_discount() {
        return goods_discount;
    }

    public void setGoods_discount(float goods_discount) {
        this.goods_discount = goods_discount;
    }

    public int getGoods_stock() {
        return goods_stock;
    }

    public void setGoods_stock(int goods_stock) {
        this.goods_stock = goods_stock;
    }

    public String getGoods_origin() {
        return goods_origin;
    }

    public void setGoods_origin(String goods_origin) {
        this.goods_origin = goods_origin;
    }

    public String getGoods_material() {
        return goods_material;
    }

    public void setGoods_material(String goods_material) {
        this.goods_material = goods_material;
    }

    public int getGoods_postalfee() {
        return goods_postalfee;
    }

    public void setGoods_postalfee(int goods_postalfee) {
        this.goods_postalfee = goods_postalfee;
    }

    public Date getGoods_date() {
        return goods_date;
    }

    public void setGoods_date(Date goods_date) {
        this.goods_date = goods_date;
    }

    public String getGoods_pic() {
        return goods_pic;
    }

    public void setGoods_pic(String goods_pic) {
        this.goods_pic = goods_pic;
    }


}
