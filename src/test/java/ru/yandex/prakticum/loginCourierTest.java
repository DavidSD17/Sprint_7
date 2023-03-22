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

public class loginCourierTest {
    private CourierClient courierClient;
    private int courierId;

    @Before
    public void setUp(){
        courierClient = new CourierClient();
    }


    @Test
    @Description("Можно создать курьера")
    public void courierCreate() {
        Courier courier = CourierGenerator.generateRandomCredentials();
        courierClient.create(courier)
                .assertThat()
                .statusCode(201)
                .and()
                .body("ok",is(true));

        courierClient.login(CourierCredentials.from(courier))
                .assertThat()
                .statusCode(200)
                .and()
                .body("id", notNullValue());
    }

    @Test
    @Description("Курьер может авторизоваться, подтверждается получением id")
    public void courierCanBeLogin() {
   CourierCredentials courierCredentials = new CourierCredentials("77David","ZZZ777");

        courierClient.login(courierCredentials)
                .assertThat()
                .statusCode(200)
                .and()
                .body("id", notNullValue());
    }

    @Test
    @Description("Авторизация под несуществующим логином возвращает ошибку")
    public void notExistLogin() {
        Courier courier =new Courier("zzzz","zzzzzz",null);
                courierClient.login(CourierCredentials.from(courier))
                .assertThat()
                .statusCode(404)
                .and()
                .body("message",equalTo("Учетная запись не найдена"));

    }


    @After
    public void clear(){
        courierClient.delete(courierId);
    }

}