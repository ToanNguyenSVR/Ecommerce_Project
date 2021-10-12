package com.nashtech.nashtech_shop.model.dto;


import com.nashtech.nashtech_shop.entity.Product;
import com.nashtech.nashtech_shop.entity.Star;
import lombok.Data;

import javax.persistence.*;


@Data
public class ReviewProductDTO {

    private Long id ;

    private String content ;




}
