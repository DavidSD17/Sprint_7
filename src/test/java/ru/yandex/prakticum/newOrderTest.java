package ru.yandex.prakticum;

import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.prakticum.client.OrderClient;
import ru.yandex.prakticum.model.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

public class newOrderTest {
    private OrderClient orderClient;

    @Before
    public void setUp(){
        orderClient = new OrderClient();
    }

    @Test
    @Description("Курьер может быть создан с корректными данными, подтверждатеся авторизацией и получением id")
    public void checkResponseNewOrder() {
        Order order = OrderGenerator.newOrderColorBlack();
        orderClient.createOrder(order)
                .assertThat()
                .statusCode(201)
                .and()
                .body("track",notNullValue());

    }

    @Test
    @Description("Курьер может быть создан с корректными данными, подтверждатеся авторизацией и получением id")
    public void createOrderWithTwoColor() {
        Order order = OrderGenerator.newOrderTwoColor();
        orderClient.createOrder(order)
                .assertThat()
                .statusCode(201)
                .and()
                .body("track",notNullValue());

    }
    @After
    public void clear(){
        orderClient.cancelOrder();
        }

}
