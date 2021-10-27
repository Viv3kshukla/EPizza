package com.directkart.epizza.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Builder
@Entity
@Table (name = "customer")
public class Customer {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String customerEmail;
    private String customerPhone;
    private LocalDate dateCreated;
}
