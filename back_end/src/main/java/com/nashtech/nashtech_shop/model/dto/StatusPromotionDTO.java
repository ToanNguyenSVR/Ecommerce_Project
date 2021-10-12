package com.nashtech.nashtech_shop.model.dto;

import com.nashtech.nashtech_shop.entity.Promotion;
import lombok.Data;

import javax.persistence.*;
import java.util.List;



@Data
public class StatusPromotionDTO {

    private int id ;

    private String status ;

}
