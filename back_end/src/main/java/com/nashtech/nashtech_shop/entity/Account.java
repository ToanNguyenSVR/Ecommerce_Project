package com.nashtech.nashtech_shop.entity;


import lombok.Data;

import javax.persistence.*;


@Entity
@Data

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String email ;
    private String password ;
    private String fullname ;
    private String phone ;
    private int  age ;
    private String gender ;
    private String create_date ;
    private String imageUrl  ;

    @ManyToOne
    @JoinColumn(name = "statusUser_id")
    private StatusUser statusUser ;

    @ManyToOne
    @JoinColumn(name = "roleUser_id")
    private RoleUser roleUser ;

    @ManyToOne
    @JoinColumn(name = "order_tbl_id")
    private Orderr_tbl orderrTbl;

}
