package com.nashtech.nashtech_shop.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String email ;
    private String password ;
    private String fullname ;
    private int  age ;
    private String gender ;
    private String create_date ;
    private String imageUrl  ;

    @ManyToOne
    @JoinColumn(name = "statusUser_id")
    private StatusUser statusUser ;

    @ManyToOne
    @JoinColumn(name = "roleUser_id")
    private RoleAccount roleAccount;

    @OneToMany(mappedBy = "account" , cascade = CascadeType.ALL)
    private List<Order> order ;
    @ManyToOne
    @JoinColumn(name = "address_User_id")
    private AddressUser address_user ;

}
