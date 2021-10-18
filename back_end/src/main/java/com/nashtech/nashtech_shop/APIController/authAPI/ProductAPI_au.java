package com.nashtech.nashtech_shop.APIController.authAPI;

import com.nashtech.nashtech_shop.Service.CategoryService;

import com.nashtech.nashtech_shop.entity.Product;
import com.nashtech.nashtech_shop.entity.ProductImage;
import com.nashtech.nashtech_shop.entity.SubCategory;

import com.nashtech.nashtech_shop.reponsitory.ProductImageReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class ProductAPI_au {
    @Autowired
    CategoryService categoryService ;
    @Autowired
    ProductImageReponsitory productImageReponsitory ;
    @RequestMapping(value = "/toan/Auth/api/1.0/product/" , method = RequestMethod.POST)
    public ResponseEntity<?> createProduct(@RequestParam(name = "name" , defaultValue = "-1") String name ,
                                           @RequestParam(name = "decription" , defaultValue = "-1") String decription ,
                                           @RequestParam(name = "image" , defaultValue = "-1") String image ,
                                           @RequestParam(value = "images" ) List<String> imageUrl  ,
                                           @RequestParam(name = "quantity" , defaultValue = "-1") Integer quantity,
                                           @RequestParam(name = "price" , defaultValue = "-1") Double price ,
                                           @RequestParam(name = "create_date" , defaultValue = "-1") String create_date,
                                           @RequestParam(name = "subCategory_id" , defaultValue = "-1") Integer subCategoryID,
                                           @RequestParam(name = "brand_id" , defaultValue = "-1") Integer brand_id
                                           ) {
        SubCategory subCategory = categoryService.findSubCategoryById(subCategoryID);
    return null ;
       // Product product = new Product(null , name , price, decription, image , null , quantity , create_date , null , null , subCategory , null  , null , brand_id , null  );

    }
}
