package com.nashtech.nashtech_shop.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity

@AllArgsConstructor
@NoArgsConstructor

public class ReviewProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String content ;

    @ManyToOne()
    @JoinColumn(name = "account_id")
    private Account account ;


    @ManyToOne()
    @JoinColumn(name = "star_id")
    private Star star ;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product products ;




}
