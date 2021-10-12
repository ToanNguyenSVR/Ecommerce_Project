package com.nashtech.nashtech_shop.model.dto;


import com.nashtech.nashtech_shop.entity.OrderDetail;
import com.nashtech.nashtech_shop.entity.ProductImage;
import com.nashtech.nashtech_shop.entity.ReviewProduct;
import com.nashtech.nashtech_shop.entity.StatusProduct;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class ProductDTO {


    private Long id ;

    private double price ;

    private String name ;

    private String decription  ;

    private String image ;

    private String color ;

    private String sold ;

    private int quantity  ;

    private  String createDate  ;


}


