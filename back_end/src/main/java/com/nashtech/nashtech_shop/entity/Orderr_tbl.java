package com.nashtech.nashtech_shop.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data

public class Orderr_tbl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;


    private String note ;
    private String creat_date ;
    private double totalPrice ;



    @OneToMany(mappedBy = "orderrTbl" , cascade = CascadeType.ALL)
    private List<Account> accounts;


    @OneToMany(mappedBy = "orderrTbl" , cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails ;

    @ManyToOne
    @JoinColumn(name = "statusOrder_id")
    private StatusOrder  statusOrder;




}
