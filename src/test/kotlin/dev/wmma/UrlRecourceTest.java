package dev.wmma;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class UrlRecourceTest {

    @Test
    public void testIfCreatingUrlEndPoint(){
        given().when().get("/url/shorten").then().statusCode(200).body(is("https://github.com/ModusCreateOrg/quarkus-demos/blob/master/user-service/src/main/kotlin/com/moduscreate/User.kt"));
    }

    @Test
    public void testIfShortUrlRedirectTOLongUrl(){
        //given().when().get("/url").then().statusCode(200).
    }


}
