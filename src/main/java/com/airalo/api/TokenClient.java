package com.airalo.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TokenClient {

    public static String getAccessToken() {
        Response response = RestAssured.given()
                .baseUri(ApiConfig.BASE_URL)
                .basePath(ApiConfig.TOKEN)
                .header("Accept", "application/json")
                .formParam("client_id", ApiConfig.CLIENT_ID)
                .formParam("client_secret", ApiConfig.CLIENT_SECRET)
                .formParam("grant_type", "client_credentials")
                .post();

        return response.jsonPath().getString("data.access_token");
    }
}
