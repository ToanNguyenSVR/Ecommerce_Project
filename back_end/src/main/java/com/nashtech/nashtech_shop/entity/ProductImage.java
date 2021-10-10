package com.nashtech.nashtech_shop.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data

public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String imageUrl ;

    @OneToMany(mappedBy = "productImages" , cascade = CascadeType.ALL)
    private List<Product> products ;


}
