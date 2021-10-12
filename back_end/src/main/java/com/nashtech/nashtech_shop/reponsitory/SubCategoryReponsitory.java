package com.nashtech.nashtech_shop.reponsitory;

import com.nashtech.nashtech_shop.entity.Account;
import com.nashtech.nashtech_shop.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryReponsitory extends JpaRepository<SubCategory , Integer  > {
}
