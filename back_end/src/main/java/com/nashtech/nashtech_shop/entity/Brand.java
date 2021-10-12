package com.nashtech.nashtech_shop.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String name ;

    private String madeIn ;

    private String decription ;

    @OneToMany(mappedBy = "brand" , cascade = CascadeType.ALL)
    private List<Product> products ;



}
