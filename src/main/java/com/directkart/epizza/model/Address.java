package com.directkart.epizza.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table (name = "address")
public class Address {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private String cityName;
    private String state;
    private String country;
    private String zipCode;
}
