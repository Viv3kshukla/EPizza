package com.directkart.epizza.model;

import com.directkart.epizza.utils.converters.HashMapConverter;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Map;

@Data
@Builder
@Entity
@Table (name = "pizza")
public class Pizza {
    @Id
    private int id;
    private String pizzaName;
    private PizzaType pizzaType;
    private PizzaSize pizzaSize;
    private Double pizzaPrice;
    @Convert (converter = HashMapConverter.class)
    private Map<String, String> nutritionalInformation;
}
