package com.nashtech.nashtech_shop.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data

public class Star {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private int star ;

    private String title ;

    @OneToMany (mappedBy = "star" , cascade  = CascadeType.ALL)
    private List<ReviewProduct> ReviewProducts;


}
