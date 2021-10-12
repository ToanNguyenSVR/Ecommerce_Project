package com.nashtech.nashtech_shop.model.mapper;


import com.nashtech.nashtech_shop.entity.Star;
import com.nashtech.nashtech_shop.model.dto.StarDTO;

public class StarMapper {
    public StarDTO ToStarDTO (Star star){
        StarDTO starDTO = new StarDTO();
        starDTO.setId(star.getId());
        starDTO.setStar(star.getStar());

        return starDTO ;
    }




}
