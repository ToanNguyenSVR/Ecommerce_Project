package com.nashtech.nashtech_shop.reponsitory;


import com.nashtech.nashtech_shop.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReponsitory extends JpaRepository<Product, Long> {


    @Query(value = " select p from Product p where p.name like  ?1 and p.statusProduct.id = ?2 ",
            countQuery = " select count (p) from Product p where p.name like  ?1 and p.statusProduct.id = ?2  ")
    public Page<Product> getProductsByStatusAndKey(Pageable pageable, String key, int status);
    @Query(value = " select p from Product p  " +
            " where p.name like  ?1  " +
            "and p.statusProduct.id = ?2    " +
            " and p.brand.id = ?2      ",
            countQuery = " select count (p)         " +
                    " from Product p           " +
                    " where p.name like  ?1   " +
                    "and p.statusProduct.id = ?2     " +
                    "  and p.brand.id = ?2     ")
    public Page<Product> getProductsByBrandIdAndStatus(Pageable pageable, String key, int brand ,int status);

    @Query(value = " select p from Product p  " +
            " inner join  p.brand b  " +
            " where p.name like  ?1  " +
            "and p.statusProduct.id = ?2  " +
            " and b.subCategory.id = ?2  ",
            countQuery = " select count (p)  " +
                    " from Product p   " +
                    " inner join  p.brand b  " +
                    " where p.name like  ?1  " +
                    "and p.statusProduct.id = ?2  " +
                    "  and b.subCategory.id = ?2  ")
    public Page<Product> getProductsBySubIDAndStatus(Pageable pageable, String key, int subCategoryId , int status);

    @Query(value = " select p from Product p  join Brand b " +
            "  on  b.id = p.brand.id   " +
            "  join SubCategory sub " +
            "  on b.subCategory.id = sub.id  " +
            "  where sub.category.id=?1 " +
            "  and p.name like ?2 " +
            "  and p.statusProduct.id = ?2   ",
            countQuery = " select count (p) from Product p inner join p.brand b inner join  b.subCategory sub where sub.category.id=?1 and p.name like ?2  and p.statusProduct.id = ?2 ")
    public Page<Product> getProductsByCategoryAndStatus(Pageable pageable, int CategoryId, String key , int status);

    public Page<Product> findAll(Pageable pageable);

    @Query(value = " select p from Product p  " +
                   " where p.name like  ?1    " +
                   " and p.brand.id = ?2      ",
      countQuery = " select count (p)         " +
                   " from Product p           " +
                   " where p.name like  ?1    " +
                   "  and p.brand.id = ?2     ")
    public Page<Product> getProductsByBrandId(Pageable pageable, String key, int brand);

    @Query(value = " select p from Product p  " +
            " inner join  p.brand b  " +
            " where p.name like  ?1  " +
            " and b.subCategory.id = ?2  ",
            countQuery = " select count (p)  " +
                    " from Product p   " +
                    " inner join  p.brand b  " +
                    " where p.name like  ?1  " +
                    "  and b.subCategory.id = ?2  ")
    public Page<Product> getProductsBySubID(Pageable pageable, String key, int subCategoryId);

    @Query(value = " select p from Product p  join Brand b " +
            "  on  b.id = p.brand.id   " +
            "  join SubCategory sub " +
            "  on b.subCategory.id = sub.id  " +
            "  where sub.category.id=?1 and p.name like ?2   ",
            countQuery = " select count (p) from Product p inner join p.brand b inner join  b.subCategory sub where sub.category.id=?1 and p.name like ?2  ")
    public Page<Product> getProductsByCategory(Pageable pageable, int CategoryId, String key);

    @Query(value = " select p from Product p where p.name like  ?1  ",
            countQuery = " select count (p) from Product p where p.name like  ?1 ")
    public Page<Product> findProductsByName(Pageable pageable, String key);


}
