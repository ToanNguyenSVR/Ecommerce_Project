package com.nashtech.nashtech_shop.model.mapper;


import com.nashtech.nashtech_shop.entity.StatusOrder;

import com.nashtech.nashtech_shop.model.dto.StatusOrderDTO;


public class StatusOrderMapper {


    public StatusOrderDTO ToStatusOrderDTO (StatusOrder statusOrder){
        StatusOrderDTO statusOrderDTO = new StatusOrderDTO();
        statusOrderDTO.setId(statusOrder.getId());
        statusOrderDTO.setStatus(statusOrder.getStatus());

        return statusOrderDTO ;
    }


}
