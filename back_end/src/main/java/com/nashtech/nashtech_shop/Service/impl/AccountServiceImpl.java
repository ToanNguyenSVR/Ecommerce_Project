package com.nashtech.nashtech_shop.Service.impl;

import com.nashtech.nashtech_shop.Service.AccountService;
import com.nashtech.nashtech_shop.entity.Account;
import com.nashtech.nashtech_shop.entity.RoleAccount;
import com.nashtech.nashtech_shop.model.dto.AccountDTO;
import com.nashtech.nashtech_shop.model.mapper.AccountMapper;
import com.nashtech.nashtech_shop.reponsitory.AccountReponsitory;
import com.nashtech.nashtech_shop.reponsitory.RoleAccountReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountReponsitory accountReponsitory ;
    @Autowired
    RoleAccountReponsitory roleAccountReponsitory;

    @Override
    public AccountDTO getAccountByEmail(String email) {

        Account account = accountReponsitory.findByEmail(email);
        if(account == null ) {
            throw new UsernameNotFoundException("Account :" + email  + " is Not Found ") ;
        }
        AccountDTO accountDTO = AccountMapper.ToAccountDTO(account);

        return accountDTO ;
    }

    @Override
    public boolean addRoleToAccount(String email, RoleAccount role) {
        boolean result = false ;
        Account account = accountReponsitory.findByEmail(email);
        if(account == null){
            throw new UsernameNotFoundException("Account :" + email  + " is Not Found ") ;

        }else {
            account.setRoleAccount(role);
            result = true ;
        }
        return result ;
    }




    @Override
    public boolean  saveAccount(Account account) {

        return (accountReponsitory.save(account) != null );
    }

    @Override
    public boolean saveRole(RoleAccount role) {
        return (roleAccountReponsitory.save(role) != null );
    }
}
