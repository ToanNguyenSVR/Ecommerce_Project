package com.nashtech.nashtech_shop.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private double price ;

    private String name ;

    private String decription  ;

    private String image ;

    private String color ;

    private String sold ;

    private int quantity  ;

    private  String createDate  ;

    @OneToMany(mappedBy = "productTbls" , cascade = CascadeType.ALL)
    private List<ReviewProduct> reviewProducts ;

    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails ;

    @ManyToOne
    @JoinColumn(name = "subCategory_id")
    private SubCategory subCategory ;

    @ManyToOne
    @JoinColumn(name = "statusProduct_id")
    private StatusProduct statusProduct ;

    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion ;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand ;

    @ManyToOne
    @JoinColumn(name = "productImage_id")
    private ProductImage productImages ;


}


