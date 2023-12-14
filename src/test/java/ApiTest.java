import config.TestConfig;
import org.testng.annotations.Test;

import static constants.Constants.Actions.SWAPI_GET_PEOPLE;
import static constants.Constants.Path.SWAPI_PATH;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest extends TestConfig {

    /* "1" - первый способ определить параметр, какого индекса мы будем брать из URI
       "SWAPIE_GET_PEOPLE" - endpoint (в нашем случае - "/people")
       ".log()" - логирование (можно логировать requests и responses, URI, exceptions etc.)
       ".log().body()" - логирование response, идет после .then */
    @Test
    public void myApiTest(){
        given()
                .log().uri()
                .when().get(SWAPI_GET_PEOPLE + "1")
                .then().log().body().statusCode(200);
    }

    /* Это тест, где мы делаем assertion на "ключ" и его "значение", используя www.swapi.dev/api
       Используем аssertion с помощью библиотеки Hamcrest, ассерт класса Matchers */
    @Test
    public void getSomeFieldAssertion(){
        given()
                .spec(requestSpecificationForSwapi).log().uri()
                .when().get(SWAPI_PATH)
                .then()
                .body("people", equalTo("https://swapi.dev/api/people/"))
                .body("planets", equalTo("https://swapi.dev/api/planets/")) //можем делать много бади (асертов)
                .log().body(); //лог - выводит "body-ответ"

    }

    //еще один тест на assert, только другого endpoint'а
    @Test
    public void getSwapiEndpointAssertion(){
        given()
                .spec(requestSpecificationForSwapi).log().uri()
                .when().get(SWAPI_PATH + SWAPI_GET_PEOPLE)
                .then()
                .body("count", equalTo(82))
                .log().body(); //лог - выводит "body-ответ"

    }
}


