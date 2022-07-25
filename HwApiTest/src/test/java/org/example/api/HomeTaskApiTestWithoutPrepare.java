package org.example.api;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class HomeTaskApiTestWithoutPrepare {

    @Test
    public void testPlaceOrder() throws IOException {
        String order = "{\n" +
                "  \"id\": 2,\n" +
                "  \"petId\": 0,\n" +
                "  \"quantity\": 0,\n" +
                "  \"shipDate\": \"2022-06-09T19:53:38.530Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}";
        given().baseUri("https://petstore.swagger.io/v2").
                basePath("/store").
                contentType(ContentType.JSON).
                body(order).
                log().all().

                when().post("order").
                then().assertThat().
                statusCode(200).
                //body("name", Matchers.notNullValue()).
                        log().all();

    }

    @Test(priority = 2)
    public void testGetOrder() throws IOException {


        given().baseUri("https://petstore.swagger.io/v2").
                basePath("/store").
                contentType(ContentType.JSON).
                log().all().

                when().get("order/2").
                then().assertThat().
                statusCode(200).
                //body("name", Matchers.notNullValue()).
                        log().all();
    }

    @Test(priority = 3)
    public void testDeleteOrder() throws IOException {
        given().baseUri("https://petstore.swagger.io/v2").
                basePath("/store").
                contentType(ContentType.JSON).
                log().all().

                when().delete("order/2").
                then().assertThat().
                statusCode(200).
                //body("name", Matchers.notNullValue()).
                        log().all();
    }

    @Test(priority = 4)
    public void testGetOrderAgain() throws IOException {


        given().baseUri("https://petstore.swagger.io/v2").
                basePath("/store").
                contentType(ContentType.JSON).
                log().all().

                when().get("order/2").
                then().assertThat().
                statusCode(404).
                log().all();
    }

}