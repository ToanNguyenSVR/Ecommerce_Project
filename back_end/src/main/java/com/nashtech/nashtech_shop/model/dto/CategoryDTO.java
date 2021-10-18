package com.nashtech.nashtech_shop.model.dto;


import com.nashtech.nashtech_shop.entity.Category;
import com.nashtech.nashtech_shop.entity.StatusCategory;
import com.nashtech.nashtech_shop.entity.SubCategory;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Stream;


@Data

public class CategoryDTO {

    private int id ;

    private String name ;
    private String imageUrl ;
    private Stream<SubCategoryDTO> subCategories ;

    public static  CategoryDTO toCategoryDTO (Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setImageUrl(category.getImageUrl());
        categoryDTO.setSubCategories(category.getSubCategories().stream().map(
                SubCategoryDTO::ToSubCategoryDTO
        ));

        return categoryDTO ;
    }

}
