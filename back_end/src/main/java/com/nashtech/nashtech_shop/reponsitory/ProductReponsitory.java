package com.nashtech.nashtech_shop.reponsitory;

import com.nashtech.nashtech_shop.entity.Account;
import com.nashtech.nashtech_shop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReponsitory extends JpaRepository<Product,Long > {

    public Page<Product> findAll(Pageable pageable);
}
