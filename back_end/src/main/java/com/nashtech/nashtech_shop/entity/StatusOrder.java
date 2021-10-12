package com.nashtech.nashtech_shop.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data

public class StatusOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String status ;

    @OneToMany(mappedBy = "statusOrder" , cascade = CascadeType.ALL)
    private List<Order> order;


}
