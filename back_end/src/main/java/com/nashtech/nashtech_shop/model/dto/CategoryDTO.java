package com.nashtech.nashtech_shop.model.dto;


import com.nashtech.nashtech_shop.entity.Category;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.ConstructorProperties;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Data
@NoArgsConstructor


public class CategoryDTO {

    private int id;


    private String name;
    private String imageUrl;
    private List<SubCategoryDTO> subCategories;

    @ConstructorProperties({"name", "imageUrl"})
    public CategoryDTO(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public static CategoryDTO toCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setImageUrl(category.getImageUrl());
        if (category.getSubCategories() != null && category.getSubCategories().size() > 0) {
            categoryDTO.setSubCategories(category.getSubCategories().stream().map(
                    SubCategoryDTO::ToSubCategoryDTO
            ).collect(Collectors.toList()));
        }

        return categoryDTO;
    }


}
