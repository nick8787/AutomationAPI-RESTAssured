import config.TestConfig;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

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
                .body("results.name[0]", equalTo("Luke Skywalker"))
                //results.name[0] - то, что лежит в массиве Results, [0] - первый ключ и его значение
                .log().body(); //лог - выводит "body-ответ"
    }

    /* Извлекаем данные из Request, с помощью метода extract */
    @Test
    public void getAllDataFromRequest(){
        Response response =
        given()
                .spec(requestSpecificationForSwapi).log().uri()
                .when().get(SWAPI_PATH)
                .then().extract().response();
        String jsonResponseAsString = response.asString();
        System.out.println(jsonResponseAsString);
    }

    /* Извлекаем Coockies из Response, с помощью метода extract */
    @Test
    public void getCoockieFromResponse(){
        Response response =
                given()
                        .spec(requestSpecificationForSwapi).log().uri()
                        .when().get(SWAPI_PATH)
                        .then().extract().response();
        Map<String, String> allCoockie = response.getCookies();
        System.out.println("allCoockie = " + allCoockie);
    }
    /* Извлекаем Headers из Response, с помощью метода extract */
    @Test
    public void getHeadersFromResponse(){
        Response response =
                given()
                        .spec(requestSpecificationForSwapi).log().uri()
                        .when().get(SWAPI_PATH)
                        .then().extract().response();
        Headers headers = response.getHeaders();
        System.out.println("headers = " + headers);

        String contentType = response.getContentType();
        System.out.println("contentType = " + contentType); //выводим конкретный хедер
    }

}


