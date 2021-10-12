package com.nashtech.nashtech_shop.model.dto;


import com.nashtech.nashtech_shop.entity.Product;
import com.nashtech.nashtech_shop.entity.StatusPromotion;
import lombok.Data;

import javax.persistence.*;
import java.util.List;



@Data

public class PromotionDTO {


    private Long id ;

    private String title ;

    private String decription ;

    private String imageUrl ;

    private int percent ;




}
