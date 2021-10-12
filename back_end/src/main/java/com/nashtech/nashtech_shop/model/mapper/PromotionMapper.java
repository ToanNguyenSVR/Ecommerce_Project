package com.nashtech.nashtech_shop.model.mapper;


import com.nashtech.nashtech_shop.entity.Promotion;
import com.nashtech.nashtech_shop.model.dto.PromotionDTO;

public class PromotionMapper {


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
