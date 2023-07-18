package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.model.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity convertDTOtoEntity(UserDTO userDTO){
        UserEntity userEntity=new UserEntity();
        userEntity.setOwnerEmail(userDTO.getOwnerEmail());
        userEntity.setOwnerName(userDTO.getOwnerName());
        userEntity.setPhone(userDTO.getPhone());
        userEntity.setPassword(userDTO.getPassword());
        return userEntity;
    }
    public UserDTO convertEntityToDTO(UserEntity userEntity){
        UserDTO userDTO=new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setOwnerEmail(userEntity.getOwnerEmail());
        userDTO.setOwnerName(userEntity.getOwnerName());
        userDTO.setPhone(userEntity.getPhone());
//        userDTO.setPassword(userEntity.getPassword());
        return userDTO;
    }
}

