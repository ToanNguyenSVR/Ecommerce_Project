package com.nashtech.nashtech_shop.entity;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity

public class ReviewProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String content ;

    @ManyToOne()
    @JoinColumn(name = "star_id")
    private Star star ;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product productTbls ;




}
