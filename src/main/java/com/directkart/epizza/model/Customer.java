package com.directkart.epizza.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "customers")
public class Customer {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String customerEmail;
    @NotNull
    private String customerPhone;
    private LocalDate createdAt;
}
