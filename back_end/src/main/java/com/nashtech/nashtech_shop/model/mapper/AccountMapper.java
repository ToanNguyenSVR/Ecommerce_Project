package com.nashtech.nashtech_shop.model.mapper;


import com.nashtech.nashtech_shop.entity.Account;
import com.nashtech.nashtech_shop.model.dto.AccountDTO;

public  class AccountMapper {

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
