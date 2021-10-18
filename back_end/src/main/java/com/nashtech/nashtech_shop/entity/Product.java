package com.nashtech.nashtech_shop.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String name ;

    private double price ;

    private String decription  ;

    private String image ;

    private int sold ;

    private int quantity  ;

    private  String createDate  ;

    @OneToMany(mappedBy = "productTbls" , cascade = CascadeType.ALL)
    private List<ReviewProduct> reviewProducts ;

    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails ;

    @ManyToOne
    @JoinColumn(name = "statusProduct_id")
    private StatusProduct statusProduct ;

    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion ;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand ;

    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL )
    private List<ProductImage> productImages;


}


