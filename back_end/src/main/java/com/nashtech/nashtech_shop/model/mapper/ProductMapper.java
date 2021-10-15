package com.nashtech.nashtech_shop.model.mapper;



import com.nashtech.nashtech_shop.entity.Product;
import com.nashtech.nashtech_shop.model.dto.ProductDTO;

public class ProductMapper {


    public static ProductDTO ToProductDTO (Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setPrice(product.getPrice());
        productDTO.setName(product.getName());
        productDTO.setDecription(product.getDecription());
        productDTO.setImage(product.getImage());
        productDTO.setColor(product.getColor());
        productDTO.setSold(product.getSold());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setCreateDate(product.getCreateDate());

        return productDTO ;
    }

}


