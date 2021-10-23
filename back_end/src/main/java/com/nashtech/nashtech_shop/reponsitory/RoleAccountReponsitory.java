package com.nashtech.nashtech_shop.reponsitory;

import com.nashtech.nashtech_shop.entity.RoleAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleAccountReponsitory extends JpaRepository<RoleAccount,Integer > {
}
