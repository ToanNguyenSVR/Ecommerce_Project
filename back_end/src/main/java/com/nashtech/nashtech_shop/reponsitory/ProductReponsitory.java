package com.nashtech.nashtech_shop.reponsitory;

import com.nashtech.nashtech_shop.entity.Account;
import com.nashtech.nashtech_shop.entity.Product;
import com.nashtech.nashtech_shop.model.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReponsitory extends JpaRepository<Product,Long > {

    public Page<Product> findAll(Pageable pageable);
    @Query(value = "select p from Product p where p.name like  ?1 and p.subCategory.id = ?2 ",
            countQuery = "select count (p) from Product p where p.name like  ?1 and p.subCategory.id = ?2")
    public Page<Product> findProductsBySubCategoryId(Pageable pageable , String key , int subCategoryId) ;

    @Query(value = "select p from Product p inner join p.subCategory sub where sub.category.id=?1 and p.name like ?2 ",
            countQuery = "select count (p) from Product p inner join p.subCategory sub where sub.category.id=?1 and p.name like ?2")
    public Page<Product> findProductsByCategory(Pageable pageable , int CategoryId , String key  ) ;

    @Query(value = "select p from Product p where p.name like  ?1 ",
            countQuery = "select count (p) from Product p where p.name like  ?1")
    public Page<Product> findProductsByName(Pageable pageable , String key  ) ;



}
