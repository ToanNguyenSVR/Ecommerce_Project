package com.nashtech.nashtech_shop.model.mapper;


import com.nashtech.nashtech_shop.entity.SubCategory;
import com.nashtech.nashtech_shop.model.dto.SubCategoryDTO;

public class SubCategoryMapper {


    public SubCategoryDTO ToSubCategoryDTO (SubCategory subCategory){
        SubCategoryDTO  subCategoryDTO = new  SubCategoryDTO();
        subCategoryDTO.setId( subCategory.getId());
        subCategoryDTO.setName( subCategory.getName());

        return  subCategoryDTO ;
    }



}
