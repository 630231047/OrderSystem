package com.jisheng.bo;

public class LookCusPaidOrder {
    /*
    orders.id,foods.name,status,num,foods.price,customers.name, "
				+ "customers.phone,customers.address
     */
    private int id;
    private String foodName;
    private String status;
    private int num;
    private int price;
    private String customerName;
    private String phone;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "LookCusPaidOrder{" +
                "id=" + id +
                ", foodName='" + foodName + '\'' +
                ", status='" + status + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", customerName='" + customerName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public LookCusPaidOrder() {
    }
}
