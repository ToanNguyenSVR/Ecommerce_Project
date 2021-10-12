package com.nashtech.nashtech_shop.model.mapper;


import com.nashtech.nashtech_shop.entity.StatusUser;
import com.nashtech.nashtech_shop.model.dto.StatusUserDTO;

public class StatusUserMapper {

    public StatusUserDTO ToStatusUserDTO (StatusUser statusUser){
        StatusUserDTO  statusUserDTO = new  StatusUserDTO();
        statusUserDTO.setId( statusUser.getId());
        statusUserDTO.setStatus( statusUser.getStatus());

        return  statusUserDTO ;
    }




}
