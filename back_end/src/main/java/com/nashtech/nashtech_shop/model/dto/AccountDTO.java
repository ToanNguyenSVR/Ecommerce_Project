package com.nashtech.nashtech_shop.model.dto;



import com.nashtech.nashtech_shop.entity.RoleAccount;

import lombok.Data;

@Data
public class AccountDTO {


    private Long id ;

    private String email ;
    private String fullname ;
    private String phone ;
    private int  age ;
    private String gender ;
    private String create_date ;
    private String imageUrl  ;
    private String roleAccount;




}
