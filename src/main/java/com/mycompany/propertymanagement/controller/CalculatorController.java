package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.model.CalculatorDTO;
import com.mycompany.propertymanagement.model.propertyDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {

    @PostMapping("/x")
    public propertyDTO saveProperty(@RequestBody propertyDTO p){
        //propertyService.saveProperty(p);
        System.out.println(p);
        return p;
    }
    @PostMapping("/mul")
    public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO cal){
        Double res=cal.getNum1()*cal.getNum2()*cal.getNum3()*cal.getNum4();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(res, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/sub/{num1}/{num2}")
    public Double substract(@PathVariable Double num1, @PathVariable Double num2){
        if (num1>num2){
            return num1-num2;
        }else{
            return num2-num1;
        }
    }
    @GetMapping("/div")
    public Double div(@RequestParam("x") Double num1,@RequestParam("y") Double num2){
        return num1+num2;
    }
    @GetMapping("/add/{num3}")
    public Double add(@RequestParam Double num1,
                      @RequestParam Double num2,
                      @PathVariable Double num3){
        return num1+num2+num3;
    }
}
