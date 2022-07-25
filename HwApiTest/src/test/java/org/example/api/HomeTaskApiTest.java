package org.example.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.example.model.Order;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class HomeTaskApiTest {
    @BeforeClass
    public void prepare() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("system.properties"));

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/")
                .addHeader("api_key", System.getProperty("api_key"))
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();


        RestAssured.filters(new ResponseLoggingFilter());

    }

    int orderId = new Random().nextInt(500000);

    @Test
    public void checkOrder() {
        Order order = new Order();

        order.setId(orderId);



        given()
                .body(order)
                .when()
                .post("/store/order")
                .then()
                .statusCode(200)
                .log().all();

        Order actual =
                given()
                        .pathParam("orderId", orderId)
                        .when()
                        .get("/store/order/{orderId}")
                        .then()
                        .statusCode(200)
                        .extract().body()
                        .as(Order.class);

        Assert.assertEquals(actual.getId(), order.getId());
    }

    @Test
    public void testDeleteOrder() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("system.properties"));
        given()
                .pathParam("orderId", orderId)
                .when()
                .delete("/store/order/{orderId}").
                then().
                statusCode(200);
        given()
                .pathParam("orderId", orderId)
                .when()
                .get("/store/order/{orderId}")
                .then()
                .statusCode(404);
    }

    @Test
    public void testInventories() throws IOException {

        System.getProperties().load(ClassLoader.getSystemResourceAsStream("system.properties"));
        String responseBody = given().contentType("application/java")
                .when()
                .get("/store/inventory")
                .then()
                .statusCode(200)
                .body("sold", Matchers.notNullValue())

                .extract().response()
                .asString();

        JsonPath inventory = new JsonPath(responseBody);
        String seriesName = inventory.getString("MRData.series");
        Assert.assertTrue(responseBody.contains("sold"));


    }


}