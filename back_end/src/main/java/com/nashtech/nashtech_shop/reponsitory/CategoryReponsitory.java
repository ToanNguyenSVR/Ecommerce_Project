package com.nashtech.nashtech_shop.reponsitory;

import com.nashtech.nashtech_shop.entity.Account;
import com.nashtech.nashtech_shop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryReponsitory extends JpaRepository<Category,Integer > {
    @Query("select c from Category c where  c.statusCategory.status Not Like ?1")
    public List<Category> findAll (String Status);
    @Query("select c from Category c where c.id = ?1 and c.statusCategory.status Not Like ?2")
    public Category getById (int id,String Status);
}
