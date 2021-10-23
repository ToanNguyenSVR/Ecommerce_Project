package com.nashtech.nashtech_shop.Service;

import com.nashtech.nashtech_shop.entity.Account;
import com.nashtech.nashtech_shop.entity.RoleAccount;
import com.nashtech.nashtech_shop.model.dto.AccountDTO;


public interface AccountService {

       AccountDTO getAccountByEmail (String email );
       boolean addRoleToAccount (String email, RoleAccount role ) ;
       boolean saveAccount (Account account );
       boolean saveRole (RoleAccount role);






}
