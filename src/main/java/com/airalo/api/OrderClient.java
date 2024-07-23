package com.airalo.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class OrderClient {

    private final String token;

    public OrderClient(String token) {
        this.token = token;
    }

    public Response createOrder(CreateOrderRequest orderRequest) {
        return given()
                .baseUri(ApiConfig.BASE_URL)
                .header("Authorization", "Bearer " + token)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .body(orderRequest)
                .when()
                .post(ApiConfig.ORDER_ESIM);
    }

    public Response getOrderDetails() {
        return given()
                .baseUri(ApiConfig.BASE_URL)
                .header("Authorization", "Bearer " + token)
                .header("Accept", "application/json")
                .param("include", "order,order.user,order.status")
                .param("limit", 10)
                .when()
                .get(ApiConfig.LIST_ESIMS);
    }
}
