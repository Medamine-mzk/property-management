package com.mycompany.propertymanagement.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)//include only Not Null fields
@JsonIgnoreProperties(ignoreUnknown = true)//ignore any unknown field
public class UserDTO {
    private Long id;
    private String ownerName;
    private String ownerEmail;
    private String phone;
    private String password;
}


