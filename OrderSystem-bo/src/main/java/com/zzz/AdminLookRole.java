package com.zzz;

public class AdminLookRole {
    /**
     * userandrole.user_id
     */
    private int user_id;
    /**
     * roles.role_name
     */
    private String role_name;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public AdminLookRole() {
    }

    @Override
    public String toString() {
        return "AdminLookRole{" +
                "user_id=" + user_id +
                ", role_name='" + role_name + '\'' +
                '}';
    }
}
