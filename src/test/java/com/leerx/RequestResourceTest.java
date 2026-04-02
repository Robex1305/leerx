package com.leerx;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class RequestResourceTest {

    @Test
    void testCreate() {
        RestAssured.given()
                .when().body("Hello'ing the world").post("/requests")
                .then()
                .statusCode(200)
                .extract().body().asString();
    }

    @Test
    void testCreateAndRead(){
        String id = RestAssured.given()
                .when().body("Hello'ing the world").post("/requests")
                .then()
                .statusCode(200)
                .extract().body().asString();

        given()
                .when().get("/requests/"+id)
                .then().statusCode(200)
                .body(is("Hello'ing the world"));
    }

    @Test
    void testUpdate(){
        String id = RestAssured.given()
            .when().body("Hello'ing the world").post("/requests")
            .then()
            .statusCode(200)
            .extract().body().asString();

        given()
                .when().get("/requests/"+id)
                .then().statusCode(200)
                .body(is("Hello'ing the world"));

        given()
                .when().body("Hello'ed the world").put("/requests/"+id)
                .then().statusCode(200);

        given()
                .when().get("/requests/"+id)
                .then().statusCode(200)
                .body(is("Hello'ed the world"));
    }

    @Test
    void testDelete(){
        String id = RestAssured.given()
                .when().body("Hello'ing the world").post("/requests")
                .then()
                .statusCode(200)
                .extract().body().asString();

        given()
                .when().get("/requests/"+id)
                .then().statusCode(200)
                .body(is("Hello'ing the world"));

        given()
                .when().delete("/requests/"+id)
                .then().statusCode(204);

        given()
                .when().get("/requests/"+id)
                .then().statusCode(404);

    }
}