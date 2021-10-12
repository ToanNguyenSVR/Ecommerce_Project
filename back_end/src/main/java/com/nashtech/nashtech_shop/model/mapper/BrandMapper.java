package com.nashtech.nashtech_shop.model.mapper;


import com.nashtech.nashtech_shop.entity.Brand;
import com.nashtech.nashtech_shop.model.dto.BrandDTO;

public class BrandMapper {
    public BrandDTO ToBrandDTO (Brand Brand){
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setId(Brand.getId());
        brandDTO.setName(Brand.getName());
        brandDTO.setDecription(Brand.getDecription());
        brandDTO.setMadeIn(Brand.getMadeIn());

        return brandDTO ;
    }




}
