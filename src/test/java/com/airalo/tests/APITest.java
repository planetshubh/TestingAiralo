package com.airalo.tests;

import com.airalo.api.CreateOrderRequest;
import com.airalo.api.OrderClient;
import com.airalo.api.TokenClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class APITest {

    private OrderClient orderClient;
    private int orderId;
    private String token;

    @BeforeClass
    public void generateToken() {
        token = TokenClient.getAccessToken();
        orderClient = new OrderClient(token);
    }

    @Test(priority = 1) // to create the order with desired input data via POST request
    public void createOrder() {
        CreateOrderRequest createOrderRequest = CreateOrderRequest.builder()
                .quantity(6)
                .packageId("merhaba-7days-1gb")
                .description("6 sims")
                .build();

        Response postResponse = orderClient.createOrder(createOrderRequest);
        postResponse.then().log().all().statusCode(200);

        String metaMessage = postResponse.jsonPath().getString("meta.message");
        orderId = postResponse.jsonPath().getInt("data.id");

        Assert.assertEquals(metaMessage, "success", "Meta message should be 'success'");
        Assert.assertNotNull(orderId, "Order ID should not be null");
    }

    @Test(priority = 2, dependsOnMethods = "createOrder") // to validate the order with the GET request
    public void validateOrder() {
        Response getResponse = orderClient.getOrderDetails();
        getResponse.then().log().all().statusCode(200);

        int totalOrdersInPage = getResponse.jsonPath().getInt("meta.to");
        boolean orderFound = false;

        for (int i = 0; i < totalOrdersInPage; i++) {
            int currentOrderId = getResponse.jsonPath().getInt("data[" + i + "].simable.id");
            if (currentOrderId == orderId) {
                orderFound = true;
                Assert.assertEquals(currentOrderId, orderId, "Order ID should match");
                Assert.assertEquals(getResponse.jsonPath()
                        .getString("data[" + i + "].simable.package_id"), "merhaba-7days-1gb", "Package ID should be 'merhaba-7days-1gb'");
                Assert.assertEquals(getResponse.jsonPath()
                        .getInt("data[" + i + "].simable.quantity"), 6, "Quantity should be 6");
                Assert.assertEquals(getResponse.jsonPath()
                        .getString("data[" + i + "].simable.description"), "6 sims", "Description should be '6 sims'");
                break;
            }
        }

        Assert.assertTrue(orderFound, "The created order should be found in the list of orders");
    }
}
