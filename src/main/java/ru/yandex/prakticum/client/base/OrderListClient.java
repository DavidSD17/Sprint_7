package ru.yandex.prakticum.client.base;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.yandex.prakticum.client.OrderClient;
import ru.yandex.prakticum.model.Order;

import static io.restassured.RestAssured.given;
import ru.yandex.prakticum.model.OrderList.*;

public class OrderListClient extends OrderClient {

    private final String LIST_OF_ORDER_BY_COURIER_URI = ORDER_URI +"?courierId=899519";

    @Step("Get list of {order}")
    public ValidatableResponse getListOfOrder() {
        return given()
                .spec(getBaseReqSpec())
                .log().all()
                .when()
                .get(ORDER_URI)
                .then().log().all();

    }

}
