package com.nashtech.nashtech_shop.model.mapper;


import com.nashtech.nashtech_shop.entity.StatusCategory;

import com.nashtech.nashtech_shop.model.dto.StatusCategoryDTO;



public class StatusCategoryMapper {

    public StatusCategoryDTO ToStatusCategoryDTO (StatusCategory statusCategory){
        StatusCategoryDTO statusCategoryDTO = new StatusCategoryDTO();
        statusCategoryDTO.setId(statusCategory.getId());
        statusCategoryDTO.setStatus(statusCategory.getStatus());

        return statusCategoryDTO ;
    }



}
