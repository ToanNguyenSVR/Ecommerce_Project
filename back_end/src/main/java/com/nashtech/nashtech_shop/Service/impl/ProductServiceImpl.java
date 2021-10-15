package com.nashtech.nashtech_shop.Service.impl;

import com.nashtech.nashtech_shop.Service.AccountService;
import com.nashtech.nashtech_shop.Service.ProductService;
import com.nashtech.nashtech_shop.entity.Account;
import com.nashtech.nashtech_shop.entity.Product;
import com.nashtech.nashtech_shop.entity.RoleAccount;
import com.nashtech.nashtech_shop.model.dto.AccountDTO;
import com.nashtech.nashtech_shop.model.dto.ProductDTO;
import com.nashtech.nashtech_shop.model.mapper.AccountMapper;
import com.nashtech.nashtech_shop.model.mapper.ProductMapper;
import com.nashtech.nashtech_shop.reponsitory.AccountReponsitory;
import com.nashtech.nashtech_shop.reponsitory.ProductReponsitory;
import com.nashtech.nashtech_shop.reponsitory.RoleAccountReponsitory;
import javassist.NotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductReponsitory productReponsitory;


    @Override
    public Page<ProductDTO> findAll(Pageable page) {
        Page<ProductDTO> productDTOS = null;
        Page<Product> products = null;
        products = productReponsitory.findAll(page);
        if (products != null) {
            productDTOS = products.map(ProductMapper::ToProductDTO);
        }
        return productDTOS;
    }

    @Override
    public Page<ProductDTO> searchProduct(Pageable Page, String key, int category, int subCategory) {
        Page<ProductDTO> result = null;

        if (subCategory != -1) {
            result = productReponsitory
                    .findProductsBySubCategoryId(Page, "%" + key + "%", subCategory)
                    .map(ProductMapper::ToProductDTO);
        } else if (category != -1) {
            result = productReponsitory
                    .findProductsByCategory(Page, category, "%" + key + "%")
                    .map(ProductMapper::ToProductDTO);
        } else {
            result = productReponsitory
                    .findProductsByName(Page, "%" + key + "%")
                    .map(ProductMapper::ToProductDTO);
        }

        return result;
    }

    @Override
    public ProductDTO findById(Long id) {
        Product product = productReponsitory.findById(id).get();
        if(product == null ){
            return null;
        }
        return ProductMapper.ToProductDTO(product);
    }

    @Override
    public ProductDTO createProduct(Product product) {
        return ProductMapper.ToProductDTO(productReponsitory.save(product));
    }

    @Override
    public ProductDTO updateProduct(Long id, Product product) {
        Product productEntity = productReponsitory.findById(id).get();
        if (productEntity == null) {
            return null;
        } else {
            productEntity = product;
            productReponsitory.deleteById(id);
            productReponsitory.save(productEntity);
            return ProductMapper.ToProductDTO(productEntity);
        }
    }

    @Override
    public ProductDTO deleteProduct(Long id) {
        Product productEntity = productReponsitory.findById(id).get();
        if (productEntity == null) {
            return null;
        } else {
            productReponsitory.deleteById(id);
            return ProductMapper.ToProductDTO(productEntity);
        }
    }
}
