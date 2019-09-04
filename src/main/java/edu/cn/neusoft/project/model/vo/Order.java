package edu.cn.neusoft.project.model.vo;

import java.util.Date;
import java.util.List;

public class Order {
    private int order_id;
    private String order_code;
    private int user_id;
    private String user_name;
    private int order_status;
    private String order_address;
    private float order_postalfee;
    private Date order_date;
    private List<OrderDetail> details;

    public Order(){

    }

    public String getOrder_code() {
        return order_code;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }

    public String getOrder_address() {
        return order_address;
    }

    public void setOrder_address(String order_address) {
        this.order_address = order_address;
    }

    public float getOrder_postalfee() {
        return order_postalfee;
    }

    public void setOrder_postalfee(float order_postalfee) {
        this.order_postalfee = order_postalfee;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }

    public Order(int order_id, String order_code, int user_id, String user_name, int order_status, String order_address, float order_postalfee, Date order_date, List<OrderDetail> details) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.user_name = user_name;
        this.order_status = order_status;
        this.order_address = order_address;
        this.order_postalfee = order_postalfee;
        this.order_date = order_date;
        this.details = details;
    }


}
