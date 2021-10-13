package com.nashtech.nashtech_shop.model.mapper;



import com.nashtech.nashtech_shop.entity.Category;
import com.nashtech.nashtech_shop.model.dto.CategoryDTO;


public class CategoryMapper {
    public CategoryDTO toCategoryDTO (Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setImageUrl(category.getImageUrl());

        return categoryDTO ;
    }
 

}
