package com.nashtech.nashtech_shop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class  StatusPromotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String status ;

    @OneToMany(mappedBy =  "statusPromotion" , cascade = CascadeType.ALL)
    private List<Promotion> promotions ;
}
