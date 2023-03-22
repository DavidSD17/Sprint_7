package ru.yandex.prakticum.client;
import com.google.gson.Gson;
import io.qameta.allure.Step;
import ru.yandex.prakticum.client.base.ScooterRestClient;
import io.restassured.response.ValidatableResponse;

import ru.yandex.prakticum.model.Order;
import ru.yandex.prakticum.model.OrderGenerator;

import static io.restassured.RestAssured.*;


public class OrderClient extends ScooterRestClient {


    protected final String ORDER_URI = BASE_URI + "orders";
    protected final String CANCEL_ORDER_URI = ORDER_URI+"/cancel";
    Gson gson = new Gson();
    Order order = OrderGenerator.newOrderColorNull();
    String json = gson.toJson(order);

    

    @Step("Create {order}")
    public ValidatableResponse createOrder(Order order) {
        return given()
                .spec(getBaseReqSpec())
                .log().all()
                .body(json)
                .when()
                .post(ORDER_URI)
                .then().log().all();

    }

    @Step("Delete {order}")
    public ValidatableResponse cancelOrder(){
        return given()
                .spec(getBaseReqSpec())
                .log().all()
                .body(json)
                .when()
                .put(CANCEL_ORDER_URI)
                .then().log().all();
    }
}