package com.nashtech.nashtech_shop.model.mapper;

import com.nashtech.nashtech_shop.entity.StatusPromotion;
import com.nashtech.nashtech_shop.model.dto.StatusPromotionDTO;


public class StatusPromotionMapper {

    public StatusPromotionDTO ToStatusPromotionDTO (StatusPromotion statusPromotion){
         StatusPromotionDTO  statusPromotionDTO = new  StatusPromotionDTO();
         statusPromotionDTO.setId( statusPromotion.getId());
         statusPromotionDTO.setStatus( statusPromotion.getStatus());

        return  statusPromotionDTO ;
    }


}
