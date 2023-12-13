import config.TestConfig;
import org.testng.annotations.Test;

import static constants.Constants.Actions.SWAPI_GET_PEOPLE;
import static io.restassured.RestAssured.given;

public class ApiTest extends TestConfig {

    @Test
    public void myApiTest(){
        given()
                .log().uri()
                .when().get(SWAPI_GET_PEOPLE + "1")
                .then().log().body().statusCode(200);
    }
}
/* "1" - первый способ определить параметр, какого индекса мы будем брать из URI
   "SWAPIE_GET_PEOPLE" - endpoint (в нашем случае - "/people")
   ".log()" - логирование (можно логировать requests и responses, URI, exceptions etc.)
   ".log().body()" - логирование response, идет после .then */

