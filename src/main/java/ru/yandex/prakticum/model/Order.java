package ru.yandex.prakticum.model;

import com.google.gson.Gson;

public class Order {

    private String firstNameCustomer;
    private String addressCustomer;
    private int metroStationCustomer;
    private String phoneCustomer;
    private int rentTime;
    private String deliveryDate;

    private String comment;
    private String[] color;

    public Order(String firstNameCustomer, String addressCustomer, int metroStationCustomer, String phoneCustomer,
                 int rentTime, String deliveryDate, String comment, String[] color) {
        this.firstNameCustomer = firstNameCustomer;
        this.addressCustomer = addressCustomer;
        this.metroStationCustomer = metroStationCustomer;
        this.phoneCustomer = phoneCustomer;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }


    public Order() {
    }


    public void setFirstNameCustomer(String firstNameCustomer) {
        this.firstNameCustomer = firstNameCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public void setMetroStationCustomer(int metroStationCustomer) {
        this.metroStationCustomer = metroStationCustomer;
    }

    public void setPhoneCustomer(String phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }

    public void setRentTime(int rentTime) {
        this.rentTime = rentTime;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setColor(String[] color) {
        this.color = color;
    }


    public String getFirstNameCustomer() {
        return firstNameCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public int getMetroStationCustomer() {
        return metroStationCustomer;
    }

    public String getPhoneCustomer() {
        return phoneCustomer;
    }

    public int getRentTime() {
        return rentTime;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getComment() {
        return comment;
    }

    public String[] getColor() {
        return color;
    }
}
