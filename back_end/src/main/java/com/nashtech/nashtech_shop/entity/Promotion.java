package com.nashtech.nashtech_shop.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data

public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String title ;

    private String decription ;

    private String imageUrl ;

    private int percent ;

    @ManyToOne
    @JoinColumn(name = "statusPromotion_id")
    private StatusPromotion statusPromotion ;

    @OneToMany(mappedBy = "promotion" , cascade = CascadeType.ALL)
    private List<Product> products ;



}
