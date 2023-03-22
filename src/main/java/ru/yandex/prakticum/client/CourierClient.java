package ru.yandex.prakticum.client;

import io.qameta.allure.Step;
import ru.yandex.prakticum.client.base.ScooterRestClient;
import ru.yandex.prakticum.model.Courier;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import ru.yandex.prakticum.model.CourierCredentials;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;


public class CourierClient extends ScooterRestClient {

    protected static final String BASE_URI = "https://qa-scooter.praktikum-services.ru/api/v1/";

    protected static final String COURIER_URI = "https://qa-scooter.praktikum-services.ru/api/v1/courier/";
    protected static final String LOGIN_URI = BASE_URI + "courier/login";
    protected static Courier courier;



    @Step("Create {courier}")
    public ValidatableResponse create(Courier courier) {
        return given()
                .spec(getBaseReqSpec())
                .log().all()
                .body(courier)
                .when()
                .post(COURIER_URI)
                .then().log().all();


    }
    @Step("Login {courierCredentials}")
    public ValidatableResponse login(CourierCredentials courierCredentials) {
        return given()
                .spec(getBaseReqSpec())
                .body(courierCredentials)
                .log().all()
                .when()
                .post(LOGIN_URI)
                .then().log().all();
    }

    @Step("Delete courier {id}")
    public ValidatableResponse delete(int id) {
        return given()
                .spec(getBaseReqSpec())
                .log().all()
                .when()
                .delete(COURIER_URI + id)
                .then().log().all();
    }
}
