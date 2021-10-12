package com.nashtech.nashtech_shop.model.dto;


import com.nashtech.nashtech_shop.entity.StatusCategory;
import com.nashtech.nashtech_shop.entity.SubCategory;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data

public class CategoryDTO {

    private int id ;

    private String name ;
    private String imageUrl ;




}
