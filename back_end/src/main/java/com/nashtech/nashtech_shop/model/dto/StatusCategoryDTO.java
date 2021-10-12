package com.nashtech.nashtech_shop.model.dto;


import com.nashtech.nashtech_shop.entity.Category;
import com.nashtech.nashtech_shop.entity.SubCategory;
import lombok.Data;

import javax.persistence.*;
import java.util.List;



@Data

public class StatusCategoryDTO {


    private int id ;

    private String status ;



}
