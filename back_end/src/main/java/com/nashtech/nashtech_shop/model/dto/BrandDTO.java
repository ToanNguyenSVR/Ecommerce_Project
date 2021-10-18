package com.nashtech.nashtech_shop.model.dto;


import com.nashtech.nashtech_shop.entity.Brand;
import com.nashtech.nashtech_shop.entity.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.List;



@Data
public class BrandDTO {

    private int id ;

    private String name ;

    public static BrandDTO ToBrandDTO (Brand Brand){
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setId(Brand.getId());
        brandDTO.setName(Brand.getName());

        return brandDTO ;
    }





}
