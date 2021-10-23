package com.nashtech.nashtech_shop.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity(name = "Order_tbl")
@Data

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;


    private String note ;
    private String creat_date ;
    private double totalPrice ;



    @ManyToOne
    @JoinColumn(name = "account_id")
    private  Account account ;


    @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails ;

    @ManyToOne
    @JoinColumn(name = "statusOrder_id")
    private StatusOrder  statusOrder;




}
