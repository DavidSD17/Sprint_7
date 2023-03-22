package ru.yandex.prakticum;

import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.prakticum.client.OrderClient;
import ru.yandex.prakticum.client.base.OrderListClient;
import ru.yandex.prakticum.model.Order;
import ru.yandex.prakticum.model.OrderGenerator;

import static org.hamcrest.CoreMatchers.notNullValue;

public class OrderListTest {

    @Before
    public void setUp(){
        OrderListClient orderListClient = new OrderListClient();
    }

    @Test
    @Description("Курьер может быть создан с корректными данными, подтверждатеся авторизацией и получением id")
    public void checkListOfOrder() {
        OrderListClient orderListClient = new OrderListClient();
        orderListClient.getListOfOrder()
                .assertThat()
                .statusCode(200)
                .and()
                .body("orders",notNullValue());
    }

}
