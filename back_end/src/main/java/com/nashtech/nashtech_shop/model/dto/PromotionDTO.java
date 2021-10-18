package com.nashtech.nashtech_shop.model.dto;


import com.nashtech.nashtech_shop.entity.Product;
import com.nashtech.nashtech_shop.entity.Promotion;
import com.nashtech.nashtech_shop.entity.StatusPromotion;
import lombok.Data;

import javax.persistence.*;
import java.util.List;



@Data

public class PromotionDTO {


    private Long id ;

    private String title ;

    private String decription ;

    private String imageUrl ;

    private int percent ;

    public PromotionDTO ToPromotionDTO (Promotion promotion){
        PromotionDTO promotionDTO = new PromotionDTO();
        promotionDTO.setId(promotion.getId());
        promotionDTO.setTitle(promotion.getTitle());
        promotionDTO.setDecription(promotion.getDecription());
        promotionDTO.setImageUrl(promotion.getImageUrl());
        promotionDTO.setPercent(promotion.getPercent());


        return promotionDTO ;
    }



}
