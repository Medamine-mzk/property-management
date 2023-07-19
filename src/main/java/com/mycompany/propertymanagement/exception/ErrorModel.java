package com.mycompany.propertymanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorModel {
    private String code;
    private String message;
}
