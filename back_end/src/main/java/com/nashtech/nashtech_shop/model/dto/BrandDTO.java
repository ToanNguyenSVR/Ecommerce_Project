package com.nashtech.nashtech_shop.model.dto;


import com.nashtech.nashtech_shop.entity.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.List;



@Data
public class BrandDTO {

    private int id ;

    private String name ;

    private String madeIn ;

    private String decription ;





}
