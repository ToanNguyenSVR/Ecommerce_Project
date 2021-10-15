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
        Page<ProductDTO> productDTOS = null ;
        Page<Product> products = null ;
        products = productReponsitory.findAll(page) ;
        if(products != null) {
            productDTOS = products.map(product -> {
                return ProductMapper.ToProductDTO(product);
            });
        }
        return productDTOS ;
    }

    @Override
    public Page<ProductDTO> searchProduct(Pageable PageAble, String key, String category) {
        return null;
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
