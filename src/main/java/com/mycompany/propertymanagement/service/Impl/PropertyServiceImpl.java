package com.mycompany.propertymanagement.service.Impl;

import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.model.propertyDTO;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;
    @Override
    public propertyDTO saveProperty(propertyDTO p) {
        PropertyEntity pe = propertyConverter.convertDtoToEntity(p);
        pe=propertyRepository.save(pe);
        p=propertyConverter.convertEntityToDto(pe);
        return p;
    }

    @Override
    public List<propertyDTO> getAllProperties() {

        List<PropertyEntity> listOfProp =(List<PropertyEntity>)propertyRepository.findAll();
        List<propertyDTO> listOfPropDto=new ArrayList<>();
        for (PropertyEntity pe : listOfProp ) {
            propertyDTO p=propertyConverter.convertEntityToDto(pe);
            listOfPropDto.add(p);
        }

        return listOfPropDto;
    }

    @Override
    public propertyDTO updateProperty(propertyDTO p, Long idProp) {
        Optional<PropertyEntity> optPe = propertyRepository.findById(idProp);
        propertyDTO pDte=null;
        if (optPe.isPresent()){
            //update
            PropertyEntity pe=optPe.get();
            pe.setTitle(p.getTitle());
            pe.setDescription(p.getDescription());
            pe.setAddress(p.getAddress());
            pe.setPrice(p.getPrice());
//            pe.setOwnerName(p.getOwnerName());
//            pe.setOwnerEmail(p.getOwnerEmail());
            propertyRepository.save(pe);
            pDte= propertyConverter.convertEntityToDto(pe);
        }
        return pDte;
    }

    @Override
    public propertyDTO updatePropertyDescription(propertyDTO p, Long idProp) {
        Optional<PropertyEntity> optPe = propertyRepository.findById(idProp);
        propertyDTO pDte=null;
        if (optPe.isPresent()){
            //update
            PropertyEntity pe=optPe.get();
            pe.setDescription(p.getDescription());
            propertyRepository.save(pe);
            pDte= propertyConverter.convertEntityToDto(pe);
        }
        return pDte;
    }

    @Override
    public propertyDTO updatePropertyPrice(propertyDTO p, Long idProp) {
        Optional<PropertyEntity> optPe = propertyRepository.findById(idProp);
        propertyDTO pDte=null;
        if (optPe.isPresent()){
            //update
            PropertyEntity pe=optPe.get();
            pe.setPrice(p.getPrice());
            propertyRepository.save(pe);
            pDte= propertyConverter.convertEntityToDto(pe);
        }
        return pDte;
    }

    @Override
    public void deleteProperty(Long idProp) {
        propertyRepository.deleteById(idProp);
    }
}
