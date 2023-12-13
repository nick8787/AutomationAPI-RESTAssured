import config.TestConfig;
import org.testng.annotations.Test;

import static constants.Constants.Actions.*;
import static io.restassured.RestAssured.given;

public class JsonPlaceHolderTest extends TestConfig {
    /* ".queryParam("postId", "1")" - второй способ определить параметр и индекс, которого мы будем брать из URI
       "JSON_PLACEHOLDER_GET" - endpoint (в нашем случае - "/people")
       ".log()" - логирование (можно логировать requests и responses, URI, exceptions etc.)
       ".log().body()" - логирование response, идет после .then */
    @Test
    public void GET(){
        given().queryParam("postId", "1").log().uri()
                .when().get(JSON_PLACEHOLDER_GET)
                .then().log().body().statusCode(200);
    }

    /* Далее тест с методом PUT */
    @Test
    public void PUT(){
        String putBodyJson = "{\n" +
                "  \"userId\": 1,\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"foo\",\n" +
                "  \"body\": \"bar\"\n" +
                "}";

        given().body(putBodyJson).log().uri()
                .when().put(JSON_PLACEHOLDER_PUT)
                .then().log().body().statusCode(200);
    }

    /* Далее тест с методом DELETE */
    @Test
    public void DELETE(){
        given().log().uri()
                .when().delete(JSON_PLACEHOLDER_DELETE)
                .then().log().body().statusCode(200);
    }

    /* Далее тест с методом POST with JSON */
    @Test
    public void PostWithJSON(){
        String postBodyJson = "{\n" +
                "\"title\":\"foo\",\n" +
                "\"body\":\"bar\",\n" +
                "\"userId\":1,\n" +
                "}";

        given().body(postBodyJson).log().all()
                .when().post(JSON_PLACEHOLDER_POST)
                .then().log().body().statusCode(201); //при методе POST - всегда 201 СТАТУС-КОД
    }
}
