package ru.yandex.prakticum.model;

import org.apache.commons.lang3.RandomStringUtils;

public class OrderGenerator {

    public static Order newOrderColorBlack() {
        String firstNameCustomer = RandomStringUtils.randomAlphabetic(7);
        String addressCustomer = "Moscow, 142 apt.";
        int metroStationCustomer = 4;
        String phoneCustomer = "+7 800 355 35 35";
        int rentTime = 5;
        String deliveryDate = "2023-03-18";
        String comment = RandomStringUtils.randomAlphabetic(7);
        String[] color = {"BLACK"};
        return new Order(firstNameCustomer, addressCustomer, metroStationCustomer, phoneCustomer,
                rentTime, deliveryDate, comment, color);
    }

    public static Order newOrderColorGrey() {
        String firstNameCustomer = RandomStringUtils.randomAlphabetic(7);
        String addressCustomer = "Moscow, 142 apt.";
        int metroStationCustomer = 4;
        String phoneCustomer = "+7 800 355 35 35";
        int rentTime = 5;
        String deliveryDate = "2023-03-18";
        String comment = RandomStringUtils.randomAlphabetic(7);
        String[] color = {"GREY"};
        return new Order(firstNameCustomer, addressCustomer, metroStationCustomer, phoneCustomer,
                rentTime, deliveryDate, comment, color);
    }

    public static Order newOrderTwoColor() {
        String firstNameCustomer = RandomStringUtils.randomAlphabetic(7);
        String addressCustomer = "Moscow, 142 apt.";
        int metroStationCustomer = 4;
        String phoneCustomer = "+7 800 355 35 35";
        int rentTime = 5;
        String deliveryDate = "2023-03-18";
        String comment = RandomStringUtils.randomAlphabetic(7);
        String[] color = {"BLACK","GREY"};
        return new Order(firstNameCustomer, addressCustomer, metroStationCustomer, phoneCustomer,
                rentTime, deliveryDate, comment, color);
    }

    public static Order newOrderColorNull() {
        String firstNameCustomer = RandomStringUtils.randomAlphabetic(7);
        String addressCustomer = "Moscow, 142 apt.";
        int metroStationCustomer = 4;
        String phoneCustomer = "+7 800 355 35 35";
        int rentTime = 5;
        String deliveryDate = "2023-03-18";
        String comment = RandomStringUtils.randomAlphabetic(7);
        String[] color = {};
        return new Order(firstNameCustomer, addressCustomer, metroStationCustomer, phoneCustomer,
                rentTime, deliveryDate, comment, color);
    }

}
