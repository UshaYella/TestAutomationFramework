package com.qa.web.driverclass;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

import static io.restassured.RestAssured.given;

public class ApiBaseClass {
    public	static String accessToken;
    public	static String healthCheck;
    @BeforeClass
    public static void initApi(){

        RestAssured.baseURI="https://restful-booker.herokuapp.com/";
       // RestAssured.basePath="/v1";
        String body = "'{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        accessToken= given()
                .when()
                .body(body)
                .post("/auth")
                .then()
                .extract()
                .path("access_token");
        System.out.println("The token is: "+accessToken);
    }
    @BeforeClass
    public static void init(){

        RestAssured.baseURI="https://restful-booker.herokuapp.com";
        // RestAssured.basePath="/v1";

        healthCheck= given()
                .when()
                .post("/auth")
                .then()
                .extract()
                .path("access_token");
        System.out.println("The token is: "+healthCheck);
    }


}
