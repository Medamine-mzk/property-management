package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.model.propertyDTO;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {
    public PropertyEntity convertDtoToEntity(propertyDTO p){
        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(p.getTitle());
        pe.setDescription(p.getDescription());
        pe.setAddress(p.getAddress());
        pe.setPrice(p.getPrice());
        pe.setOwnerName(p.getOwnerName());
        pe.setOwnerEmail(p.getOwnerEmail());
        return pe;
    }
    public propertyDTO convertEntityToDto(PropertyEntity pe){
        propertyDTO p = new propertyDTO();
        p.setId(pe.getId());
        p.setTitle(pe.getTitle());
        p.setDescription(pe.getDescription());
        p.setAddress(pe.getAddress());
        p.setPrice(pe.getPrice());
        p.setOwnerName(pe.getOwnerName());
        p.setOwnerEmail(pe.getOwnerEmail());
        return p;
    }
}
