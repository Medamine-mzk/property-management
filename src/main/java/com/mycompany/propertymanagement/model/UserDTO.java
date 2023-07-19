package com.mycompany.propertymanagement.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)//include only Not Null fields
@JsonIgnoreProperties(ignoreUnknown = true)//ignore any unknown field
public class UserDTO {
    private Long id;
    private String ownerName;
    @NotNull(message = "Owner Email is mandatory !")
    @NotEmpty(message = "Owner Email cannot be empty !")
    @Size(min = 3,max = 50,message = "Owner Emeil should be between 1 and 50 characters")
    @Email(message = "Owner Email is not valid !")
    private String ownerEmail;
    private String phone;
    @NotNull(message = "Password is mandatory !")
    @NotEmpty(message = "Password cannot be empty !")
    private String password;
}
