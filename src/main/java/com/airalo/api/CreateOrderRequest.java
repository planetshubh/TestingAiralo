package com.airalo.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateOrderRequest {
    private int quantity;

    @JsonProperty("package_id")
    private String packageId;

    private String description;
}
