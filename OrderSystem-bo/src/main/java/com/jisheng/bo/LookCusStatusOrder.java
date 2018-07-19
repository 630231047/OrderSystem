package com.jisheng.bo;

public class LookCusStatusOrder {
    private int id;//orders.id
    private String name;//foods.name
    private String status;//orders.status
    private int num;//
    private int price;//foods.price
    private String date;//date
    private String store_name;//stores.store_name
    private int store_id;//orders.store_id

    public LookCusStatusOrder() {
    }

    @Override
    public String toString() {
        return "LookCusStatusOrder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", store_name='" + store_name + '\'' +
                ", store_id=" + store_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }
}
