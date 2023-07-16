package com.mycompany.propertymanagement.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class propertyDTO {
    private Long id;
    private String title;
    private String description;
    private String ownerName;
    private String ownerEmail;
    private Double price;
    private String address;

    @Override
    public String toString() {
        return "propertyDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerEmail='" + ownerEmail + '\'' +
                ", price=" + price +
                ", address='" + address + '\'' +
                '}';
    }
}