package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.model.propertyDTO;

import java.util.List;

public interface PropertyService {
    propertyDTO saveProperty(propertyDTO p);
    List<propertyDTO> getAllProperties();
    propertyDTO updateProperty(propertyDTO p,Long idProp);
    propertyDTO updatePropertyDescription(propertyDTO p,Long idProp);
    propertyDTO updatePropertyPrice(propertyDTO p,Long idProp);
    void deleteProperty(Long idProp);

}
