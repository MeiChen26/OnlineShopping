package edu.cn.neusoft.project.model.vo;



public class Color {

    private int color_id;
    private String color_name;


    public Color(){

    }

    public int getColor_id() {
        return color_id;
    }

    public void setColor_id(int color_id) {
        this.color_id = color_id;
    }

    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }

    public Color(int color_id, String color_name) {
        this.color_id = color_id;
        this.color_name = color_name;
    }
}
