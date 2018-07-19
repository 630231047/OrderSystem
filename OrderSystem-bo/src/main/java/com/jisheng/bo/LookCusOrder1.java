package com.jisheng.bo;

public class LookCusOrder1 {
    /**
     *  SELECT orders.id,foods.name,status,num,foods.price
     */
    private int id;
    private String name;
    private String status;
    private int num;
    private int price;

    public LookCusOrder1() {
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

    @Override
    public String toString() {
        return "LookCusOrder1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", num=" + num +
                ", price=" + price +
                '}';
    }
}
