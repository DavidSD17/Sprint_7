package ru.yandex.prakticum;


import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.prakticum.client.OrderClient;
import ru.yandex.prakticum.model.Order;
import ru.yandex.prakticum.model.OrderGenerator;

import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class)
public class createOrderParamTest extends OrderClient {

    public static Order orderBlack = OrderGenerator.newOrderColorBlack();
    public static Order orderGrey = OrderGenerator.newOrderColorGrey();
    public static Order orderColorNull = OrderGenerator.newOrderColorNull();

    static OrderClient orderClient;

    public createOrderParamTest(Order orderBlack) {
        this.orderBlack = orderBlack;

    }

    @Before
    public void setUp() {
        orderClient = new OrderClient();
    }

    @Parameterized.Parameters(name = "{index}:{0}")
    public static Object[][] getTestDataOrder() {
        return new Object[][]{
                {orderBlack},
                {orderGrey},
                {orderColorNull}

        };
    }

    @Test
    @Description("При создании заказа, тело ответа содержит track")
    public void checkResponseNewOrder() {
        orderClient.createOrder(orderBlack)
                .assertThat()
                .statusCode(201)
                .and()
                .body("track", notNullValue());

    }
    @After
    public void clear(){
        orderClient.cancelOrder();
    }
}
