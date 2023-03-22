package ru.yandex.prakticum.client.base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ScooterRestClient {
    public static final String BASE_URI = "https://qa-scooter.praktikum-services.ru/api/v1/";
    protected RequestSpecification getBaseReqSpec(){
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URI)
                .build();
    }
}
