package com.nashtech.nashtech_shop.model.dto;


import com.nashtech.nashtech_shop.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {


    private Long id ;

    private double price ;

    private String name ;

    private String decription  ;

    private String image ;

    private int sold ;

    private int quantity  ;

    private  String createDate  ;

    private String promotion ;

    private  String brand ;
    private  String subCategory ;




    public static ProductDTO ToProductDTO (Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setPrice(product.getPrice());
        productDTO.setName(product.getName());
        productDTO.setDecription(product.getDecription());
        productDTO.setImage(product.getImage());
        if(product.getPromotion() != null ) {
            productDTO.setPromotion(product.getPromotion().getPercent() + "%");
        }
        productDTO.setSold(product.getSold());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setCreateDate(product.getCreateDate());
        if(product.getBrand() != null ) {
            productDTO.setBrand(product.getBrand().getName());
        }
        if(product.getSubCategory() != null) {
            productDTO.setSubCategory(product.getSubCategory().getName());
        }

        return productDTO ;
    }




}


