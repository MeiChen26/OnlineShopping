package edu.cn.neusoft.project.model.vo;

public class User {

    private int user_id;
    private String user_name;
    private String user_password;
    private String user_age;
    private String user_sex;
    private String user_email;
    private int user_rank;

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User(int user_id, String user_name, String user_password, String user_age, String user_sex, String user_email, int user_rank) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_age = user_age;
        this.user_sex = user_sex;
        this.user_email = user_email;
        this.user_rank = user_rank;
    }

    public User(String user_name, String user_password) {
        this.user_name = user_name;
        this.user_password = user_password;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_age='" + user_age + '\'' +
                ", user_sex='" + user_sex + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_rank=" + user_rank +
                '}';
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

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_age() {
        return user_age;
    }

    public void setUser_age(String user_age) {
        this.user_age = user_age;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public int getUser_rank() {
        return user_rank;
    }

    public void setUser_rank(int user_rank) {
        this.user_rank = user_rank;
    }
}