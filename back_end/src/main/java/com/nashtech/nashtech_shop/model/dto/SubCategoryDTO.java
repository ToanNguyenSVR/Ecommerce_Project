package com.nashtech.nashtech_shop.model.dto;


import com.nashtech.nashtech_shop.entity.Category;
import com.nashtech.nashtech_shop.entity.Product;
import com.nashtech.nashtech_shop.entity.StatusCategory;
import com.nashtech.nashtech_shop.entity.SubCategory;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data

public class SubCategoryDTO {

    private int id ;

    private String name ;

    public static SubCategoryDTO ToSubCategoryDTO (SubCategory subCategory){
        SubCategoryDTO  subCategoryDTO = new  SubCategoryDTO();
        subCategoryDTO.setId( subCategory.getId());
        subCategoryDTO.setName( subCategory.getName());

        return  subCategoryDTO ;
    }




}
