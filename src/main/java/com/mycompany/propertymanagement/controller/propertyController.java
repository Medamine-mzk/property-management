package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.model.CalculatorDTO;
import com.mycompany.propertymanagement.model.propertyDTO;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class propertyController {

    @Value("${pms.medconfig:}")
    private String medconfig;
    @Value("${spring.datasource.username:}")
    private String username;

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @PostMapping("/properties")
    public  ResponseEntity<propertyDTO> saveProperty(@RequestBody propertyDTO p){
        p=propertyService.saveProperty(p);
        System.out.println(p);
        ResponseEntity<propertyDTO> responseEntity=new ResponseEntity<>(p,HttpStatus.CREATED);
        return responseEntity;
    }
    @GetMapping("/properties")
    public  ResponseEntity<List<propertyDTO>> getAllProperties(){
        List<propertyDTO> allProp = propertyService.getAllProperties();
        ResponseEntity<List<propertyDTO>> responseEntity=new ResponseEntity<>(allProp,HttpStatus.OK);
        return responseEntity;
    }
    @PutMapping("/properties/{idProp}")
    public  ResponseEntity<propertyDTO> updateProperty(@RequestBody propertyDTO p,@PathVariable Long idProp){
        p=propertyService.updateProperty(p,idProp);
        ResponseEntity<propertyDTO> responseEntity=new ResponseEntity<>(p,HttpStatus.OK);
        return responseEntity;
    }
    @PatchMapping("/properties/update-description/{idProp}")
    public  ResponseEntity<propertyDTO> updatePropertyDescription(@RequestBody propertyDTO p,@PathVariable Long idProp){
        p=propertyService.updatePropertyDescription(p,idProp);
        ResponseEntity<propertyDTO> responseEntity=new ResponseEntity<>(p,HttpStatus.OK);
        return responseEntity;
    }
    @PatchMapping("/properties/update-price/{idProp}")
    public  ResponseEntity<propertyDTO> updatePropertyPrice(@RequestBody propertyDTO p,@PathVariable Long idProp){
        p=propertyService.updatePropertyPrice(p,idProp);
        ResponseEntity<propertyDTO> responseEntity=new ResponseEntity<>(p,HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("/properties/{idProp}")
    public  ResponseEntity<Void> deleteProperty(@PathVariable Long idProp){
        propertyService.deleteProperty(idProp);
        ResponseEntity<Void> responseEntity=new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        return responseEntity;
    }
    @GetMapping("/print-config")
    public  void printConfig(){
        System.out.println(medconfig);
        System.out.println(username);
    }
}
