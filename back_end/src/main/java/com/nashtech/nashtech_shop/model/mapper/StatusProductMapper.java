package com.nashtech.nashtech_shop.model.mapper;


import com.nashtech.nashtech_shop.entity.StatusProduct;
import com.nashtech.nashtech_shop.model.dto.StatusProductDTO;

public class StatusProductMapper {

    public StatusProductDTO ToStatusProductDTO (StatusProduct statusProduct){
        StatusProductDTO statusProductDTO = new StatusProductDTO();
        statusProductDTO.setId(statusProduct.getId());
        statusProductDTO.setStatus(statusProduct.getStatus());

        return statusProductDTO ;
    }


}
