package com.nashtech.nashtech_shop.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data

public class RoleAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String  role ;

    @OneToMany(mappedBy = "roleAccount" , cascade = CascadeType.ALL)
    private List<Account> accounts;


}
