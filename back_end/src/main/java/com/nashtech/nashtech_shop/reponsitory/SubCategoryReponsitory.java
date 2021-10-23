package com.nashtech.nashtech_shop.reponsitory;

import com.nashtech.nashtech_shop.entity.Account;
import com.nashtech.nashtech_shop.entity.SubCategory;
import com.nashtech.nashtech_shop.model.dto.SubCategoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryReponsitory extends JpaRepository<SubCategory , Integer  > {

    @Query("select s from SubCategory s where s.category.id = ?1 and s.statusSubCategory.status Not LIKE ?2")
    public List<SubCategory> findByCategoryId (int categoryID , String Status) ;
    @Query("select s from SubCategory s where s.id = ?1 and s.statusSubCategory.status Not LIKE ?2")
    public SubCategory findById(int id , String status);
}
