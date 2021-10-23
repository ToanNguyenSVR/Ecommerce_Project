package com.nashtech.nashtech_shop.model.dto;


import com.nashtech.nashtech_shop.entity.Product;
import com.nashtech.nashtech_shop.entity.ProductImage;
import lombok.Data;

import javax.persistence.*;
import java.util.List;



@Data

public class ProductImageDTO {


    private Long id ;

    private String imageUrl ;

    public static  ProductImageDTO ToProductImageDTO (ProductImage productImage){
        ProductImageDTO productImageDTO = new ProductImageDTO();
        productImageDTO.setId(productImage.getId());
        productImageDTO.setImageUrl(productImage.getImageUrl());

        return productImageDTO ;
    }



}
