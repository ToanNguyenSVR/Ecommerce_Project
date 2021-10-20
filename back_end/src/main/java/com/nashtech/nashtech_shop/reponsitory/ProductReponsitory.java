package com.nashtech.nashtech_shop.reponsitory;


import com.nashtech.nashtech_shop.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReponsitory extends JpaRepository<Product, Long> {


    public List<Product> findAll();

    @Query(value = " select p from Product p where p.name like  ?1 and p.brand.id = ?2")
    public List<Product> getProductsByBrandId(String key, int brand);

    @Query(value = " select p from Product p where p.name like  ?1 and p.subCategory.id = ?2  ")
    public List<Product> getProductsBySubID(String key, int subCategoryId);

    @Query(value = "select  p from  Product p where  p.name like ?1 and p.subCategory.category.id = ?2")
    public List<Product> getProductsByCategory(String key, int CategoryId);

    @Query(value = " select p from Product p where p.name like  ?1  ")
    public List<Product> findProductsByName(String key);
    public List<Product> findProductsByPromotionId(int id );


}
