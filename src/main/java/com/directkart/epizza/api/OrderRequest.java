package com.directkart.epizza.api;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@JsonNaming (value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderRequest {

    @NotNull
    public Long customerId;
    public String firstName;
    public String lastName;
    public String customerEmail;
    public String customerPhone;
    public String shippingCountry;
    public String shippingCityName;
    public String shippingState;
    public String shippingStreetName;
    public String shippingZipCode;
    public String billingCountry;
    public String billingCityName;
    public String billingState;
    public String billingStreetName;
    public String billingZipCode;

}
