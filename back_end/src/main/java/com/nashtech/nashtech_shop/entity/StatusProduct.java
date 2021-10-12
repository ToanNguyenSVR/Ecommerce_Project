package com.nashtech.nashtech_shop.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data

public class StatusProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String status ;


    @OneToMany(mappedBy = "statusProduct" , cascade = CascadeType.ALL)
    private List<Product> products ;

}
