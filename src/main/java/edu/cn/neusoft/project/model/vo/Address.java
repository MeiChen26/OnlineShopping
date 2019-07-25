package edu.cn.neusoft.project.model.vo;

public class Address {
    private int addr_id;
    private int user_id;
    private String addr_province;
    private String addr_city;
    private String addr_area;
    private String addr_content;
    private String addr_receiver;
    private String addr_tel;
    private String addr_isdefault;

    public int getAddr_id() {
        return addr_id;
    }

    public void setAddr_id(int addr_id) {
        this.addr_id = addr_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAddr_province() {
        return addr_province;
    }

    public void setAddr_province(String addr_province) {
        this.addr_province = addr_province;
    }

    public String getAddr_city() {
        return addr_city;
    }

    public void setAddr_city(String addr_city) {
        this.addr_city = addr_city;
    }

    public String getAddr_area() {
        return addr_area;
    }

    public void setAddr_area(String addr_area) {
        this.addr_area = addr_area;
    }

    public String getAddr_content() {
        return addr_content;
    }

    public void setAddr_content(String addr_content) {
        this.addr_content = addr_content;
    }

    public String getAddr_receiver() {
        return addr_receiver;
    }

    public void setAddr_receiver(String addr_receiver) {
        this.addr_receiver = addr_receiver;
    }

    public String getAddr_isdefault() {
        return addr_isdefault;
    }

    public void setAddr_isdefault(String addr_isdefault) {
        this.addr_isdefault = addr_isdefault;
    }

    public Address(){

    }

    public String getAddr_tel() {
        return addr_tel;
    }

    public void setAddr_tel(String addr_tel) {
        this.addr_tel = addr_tel;
    }

    public Address(int addr_id, int user_id, String addr_province, String addr_city, String addr_area, String addr_content, String addr_receiver, String addr_tel, String addr_isdefault) {
        this.addr_id = addr_id;
        this.user_id = user_id;
        this.addr_province = addr_province;
        this.addr_city = addr_city;
        this.addr_area = addr_area;
        this.addr_content = addr_content;
        this.addr_receiver = addr_receiver;
        this.addr_tel = addr_tel;
        this.addr_isdefault = addr_isdefault;
    }
}
