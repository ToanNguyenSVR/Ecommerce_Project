package com.nashtech.nashtech_shop.model.dto;


import com.nashtech.nashtech_shop.entity.Brand;
import com.nashtech.nashtech_shop.entity.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;


@Data
public class BrandDTO {

    private int id ;

    private String name ;

    private  List<ProductDTO> productDTOS ;

    public static BrandDTO ToBrandDTO (Brand brand){
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setId(brand.getId());
        brandDTO.setName(brand.getName());
        if(brand.getProducts() != null && brand.getProducts().size() > 0 ) {
            brandDTO.setProductDTOS(brand.getProducts().stream().map(ProductDTO::ToProductDTO).collect(Collectors.toList()));
        }
        return brandDTO ;
    }





}
