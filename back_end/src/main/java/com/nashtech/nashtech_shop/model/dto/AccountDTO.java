package com.nashtech.nashtech_shop.model.dto;



import com.nashtech.nashtech_shop.entity.Account;
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

    public static AccountDTO ToAccountDTO (Account account){
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setEmail(account.getEmail());
        accountDTO.setFullname(account.getFullname());

        accountDTO.setAge(account.getAge());
        accountDTO.setGender(account.getGender());
        accountDTO.setCreate_date(account.getCreate_date());
        accountDTO.setImageUrl(account.getImageUrl());
        accountDTO.setRoleAccount(account.getRoleAccount().getRole());
        return accountDTO ;
    }




}
