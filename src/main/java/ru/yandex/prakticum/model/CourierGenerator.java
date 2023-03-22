package ru.yandex.prakticum.model;
import org.apache.commons.lang3.RandomStringUtils;

public class CourierGenerator {

    public static Courier generateRandomCredentials(){
        String login = RandomStringUtils.randomAlphabetic(7);
        String password = RandomStringUtils.randomAlphabetic(8);
        String firstName = RandomStringUtils.randomAlphabetic(9);
        return new Courier(login,password,firstName);
    }

    public static Courier generateRandomExceptFirstName(){
        String login = RandomStringUtils.randomAlphabetic(7);
        String password = RandomStringUtils.randomAlphabetic(7);
        String firstName = null;
        return new Courier(login,password,firstName);
    }

    public static Courier generateRandomExceptLogin(){
        String login = null;
        String password = RandomStringUtils.randomAlphabetic(7);
        String firstName = RandomStringUtils.randomAlphabetic(7);
        return new Courier(login,password,firstName);
    }

    public static Courier generateRandomExceptPass(){
        String login = RandomStringUtils.randomAlphabetic(7);
        String password = null;
        String firstName = RandomStringUtils.randomAlphabetic(7);
        return new Courier(login,password,firstName);
    }
}
