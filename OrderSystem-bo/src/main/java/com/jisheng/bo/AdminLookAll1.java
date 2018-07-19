package com.jisheng.bo;

public class AdminLookAll1 {
    /*
            SELECT role_id,role_name FROM roles
     */
    private int role_id;
    private String role_name;

    @Override
    public String toString() {
        return "AdminLookAll1{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                '}';
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public AdminLookAll1() {
    }
}
