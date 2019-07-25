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
    private String order_postcode;
    private String order_postname;
    private List<OrderDetail> details;
}
