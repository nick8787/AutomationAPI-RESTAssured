import config.TestConfig;
import org.testng.annotations.Test;

import static constants.Constants.Actions.JSON_PLACEHOLDER_GET;
import static io.restassured.RestAssured.given;

public class JsonPlaceHolderTest extends TestConfig {

    @Test
    public void GET(){
        given().queryParam("postId", "1").log().uri()
                .when().get(JSON_PLACEHOLDER_GET)
                .then().log().body().statusCode(200);
    }
}
/* ".queryParam("postId", "1")" - второй способ определить параметр и индекс, которого мы будем брать из URI
   "JSON_PLACEHOLDER_GET" - endpoint (в нашем случае - "/people")
   ".log()" - логирование (можно логировать requests и responses, URI, exceptions etc.)
   ".log().body()" - логирование response, идет после .then */