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
    public String country;
    public String cityName;
    public String state;
    public String streetName;
    public String zipCode;

}
