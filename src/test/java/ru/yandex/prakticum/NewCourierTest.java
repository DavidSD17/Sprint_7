package ru.yandex.prakticum;

import io.qameta.allure.Description;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.prakticum.client.CourierClient;
import ru.yandex.prakticum.model.Courier;
import ru.yandex.prakticum.model.CourierCredentials;
import ru.yandex.prakticum.model.CourierGenerator;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;


public class NewCourierTest {

    private CourierClient courierClient;
    private int courierId;

    @Before
    public void setUp(){
        courierClient = new CourierClient();
    }


    @Test
    @Description("Курьер может быть создан с корректными данными, подтверждатеся авторизацией и получением id")
    public void courierCanBeCreatedWithCorrectData() {
        Courier courier = CourierGenerator.generateRandomCredentials();
        courierClient.create(courier)
                .assertThat()
                .statusCode(201)
                .and()
                .body("ok",is(true));

        ValidatableResponse loginResponse = courierClient.login(CourierCredentials.from(courier));
        courierId = loginResponse.extract().path("id");

        courierClient.login(CourierCredentials.from(courier))
                .assertThat()
                .statusCode(200)
                .and()
                .body("id", notNullValue());
    }
    @Test
    @Description("Нельзя создать двух одинаковых курьеров")
    public void courierNotDouble() {
        Courier courier =new Courier("myLogin","myPass","myName");
        courierClient.create(courier)
                .assertThat()
                .statusCode(201)
                .and()
                .body("ok",is(true));

        ValidatableResponse loginResponse = courierClient.login(CourierCredentials.from(courier));
        courierId = loginResponse.extract().path("id");

        courierClient.create(courier)
                .assertThat()
                .statusCode(409)
                .and()
                .body("message",equalTo("Этот логин уже используется. Попробуйте другой."));
        courierClient.delete(courierId);
    }

    @Test
    @Description("Нельзя создать курьера без логина")
    public void courierWithoutLogin() {
        Courier courier = CourierGenerator.generateRandomExceptLogin();
        courierClient.create(courier)
                .assertThat()
                .statusCode(400)
                .and()
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    @Test
    @Description("Нельзя создать курьера без пароля")
    public void courierWithoutPass() {
        Courier courier = CourierGenerator.generateRandomExceptPass();
        courierClient.create(courier)
                .assertThat()
                .statusCode(400)
                .and()
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    @Test
    @Description("Нельзя создать курьера без Имени")
    public void courierWithoutFirstName() {
        Courier courier = CourierGenerator.generateRandomExceptFirstName();
        courierClient.create(courier)
                .assertThat()
                .statusCode(201)
                .and()
                .body("ok", is(true));
    }


    @After
    public void clear(){
        courierClient.delete(courierId);
    }

}




//        ValidatableResponse createResponse = courierClient.create(courier);
//        int statusCode = createResponse.extract().statusCode();
//        Boolean isCourierCreated = createResponse.extract().path("ok");
//        assertEquals("Status code is 201",201,statusCode);
//        assertTrue("Courier is not created",isCourierCreated);
//
//        ValidatableResponse loginResponse = courierClient.login(CourierCredentials.from(courier));
//        courierId = loginResponse.extract().path("id");
//        assertTrue("Courier id is not created",courierId != 0);
