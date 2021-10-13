package com.nashtech.nashtech_shop.Service.impl;

import com.nashtech.nashtech_shop.Service.AccountService;
import com.nashtech.nashtech_shop.entity.Account;
import com.nashtech.nashtech_shop.reponsitory.AccountReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountReponsitory accountReponsitory ;

    @Override
    public Account  checkLogin (String email) {

    return null ;
    }
}
