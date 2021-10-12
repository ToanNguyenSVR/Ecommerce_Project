package com.nashtech.nashtech_shop.model.dto;


import com.nashtech.nashtech_shop.entity.Account;
import lombok.Data;

import javax.persistence.*;
import java.util.List;



@Data

public class RoleUserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String  role ;



}
