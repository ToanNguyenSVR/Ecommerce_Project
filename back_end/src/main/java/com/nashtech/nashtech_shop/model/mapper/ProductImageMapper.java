package com.nashtech.nashtech_shop.model.mapper;



import com.nashtech.nashtech_shop.entity.ProductImage;
import com.nashtech.nashtech_shop.model.dto.ProductImageDTO;


public class ProductImageMapper {

    public ProductImageDTO ToProductImageDTO (ProductImage productImage){
        ProductImageDTO productImageDTO = new ProductImageDTO();
        productImageDTO.setId(productImage.getId());
        productImageDTO.setImageUrl(productImage.getImageUrl());

        return productImageDTO ;
    }

}
