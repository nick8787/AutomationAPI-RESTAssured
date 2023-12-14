package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import static constants.Constants.RunVeriable.path;
import static constants.Constants.RunVeriable.server;
import static constants.Constants.Servers.SWAPI_URL;

public class TestConfig {

    /* Эта переменная используется для метода в ApiTest, для assertion */
    protected RequestSpecification requestSpecificationForSwapi = new RequestSpecBuilder()
            .setBaseUri(SWAPI_URL)
            .build();

    /* Это метод, где мы насетапили server - URL ("https://swapi.dev/")
       и также path это - "/api" */
    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = server;
        RestAssured.basePath = path;

    /* Смысл RequestSpecification в том, чтобы создать уникальный запрос,
       с помощью Request Builder'а - мы можем добавить разны свойства объекту (Header'ы, coockie, URL и т.д.).
       Также нашему RequestSpecification необходимо задать значение (делаем это ниже)
       реализуем это в тесте, например, POST */
    RequestSpecification myRequestSpecification = new RequestSpecBuilder()
        .addHeader("Content-Type", "application/json")
        .addCookie("someCoockie")
        .build();

    RestAssured.requestSpecification = myRequestSpecification;
    }
}
