package com.nashtech.nashtech_shop.Service.impl;


import com.nashtech.nashtech_shop.Service.ProductService;

import com.nashtech.nashtech_shop.entity.Product;

import com.nashtech.nashtech_shop.model.dto.ProductDTO;

import com.nashtech.nashtech_shop.reponsitory.ProductReponsitory;

import com.nashtech.nashtech_shop.utils.MyUtils;
import com.nashtech.nashtech_shop.utils.MyUtils.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductReponsitory productReponsitory;


    @Override
    public List<ProductDTO> findAll() {
        List<ProductDTO> productDTOS = null;
        List<Product> products = null;
        try {
            products = productReponsitory.findAll();
            if (products != null) {
                productDTOS = products.stream().map(ProductDTO::ToProductDTO
                ).collect(Collectors.toList());
            }
        } catch (Exception e) {
            throw e;
        }
        return productDTOS;
    }

    @Override
    public List<ProductDTO> searchProduct(String key, Map<String, Integer > value) {
        List<ProductDTO> result = null;
        List<Product> products = null;
        boolean haveType = false;
        try {
            for (String type : MyUtils.searchType) {
               if(value.containsKey(type.toLowerCase())){
                   haveType = true ;
                   System.out.println(type);
               }
            }
            if(haveType){
                products = findProductByType( key, value);
            }else{
                products = productReponsitory.findProductsByName("%" + key +"%" );
            }
            if(products != null ){
                result = products.stream().map(ProductDTO::ToProductDTO).collect(Collectors.toList());
            }


        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    private List<Product> findProductByType( String key, Map<String, Integer> value ) {
        List<Product> result = null;

        for (String type : value.keySet()) {
            switch (type.trim().toLowerCase()){
                case "category":
                    result = productReponsitory.getProductsByCategory("%" + key + "%" , value.get(type));
                    break;
                case "subcategory":
                    result = productReponsitory.getProductsBySubID("%" + key + "%" , value.get(type));
                    break;
                case "brand":
                    result = productReponsitory.getProductsByBrandId("%" + key + "%" , value.get(type));
                    break;
                case "promotion":
                    result = productReponsitory.findProductsByPromotionId(value.get(type));
                    break;
            }

        }
        return result ;


    }



    @Override
    public ProductDTO findById(Long id) {
        Product product = productReponsitory.findById(id).get();
        if (product == null) {
            return null;
        }
        return ProductDTO.ToProductDTO(product);
    }

    @Override
    public ProductDTO createProduct(Product product) {
        return ProductDTO.ToProductDTO(productReponsitory.save(product));
    }

    @Override
    public ProductDTO updateProduct( Product product) {
        Product productEntity = productReponsitory.findById(product.getId()).get();
        if (productEntity == null) {
            return null;
        } else {
        Product r = productReponsitory.save(product);
        }
        return ProductDTO.ToProductDTO(product);
    }

    @Override
    public ProductDTO deleteProduct(Long id) {
        Product productEntity = productReponsitory.findById(id).get();
        if (productEntity == null) {
            return null;
        } else {
            productReponsitory.deleteById(id);
            return ProductDTO.ToProductDTO(productEntity);
        }
    }
}
