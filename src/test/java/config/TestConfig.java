package config;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import static constants.Constants.RunVeriable.path;
import static constants.Constants.RunVeriable.server;

public class TestConfig {

    /*это метод, где мы насетапили server - URL ("https://swapi.dev/")
      и также path это - "/api" */
    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = server;
        RestAssured.basePath = path;
    }
}
