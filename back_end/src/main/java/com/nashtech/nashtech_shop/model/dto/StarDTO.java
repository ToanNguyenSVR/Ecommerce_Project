package com.nashtech.nashtech_shop.model.dto;


import com.nashtech.nashtech_shop.entity.ReviewProduct;
import lombok.Data;

import javax.persistence.*;
import java.util.List;



@Data

public class StarDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private int star ;

    private String title ;




}
