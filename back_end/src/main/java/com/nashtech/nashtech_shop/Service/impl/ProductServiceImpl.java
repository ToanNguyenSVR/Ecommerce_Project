package com.nashtech.nashtech_shop.Service.impl;


import com.nashtech.nashtech_shop.Service.ProductService;

import com.nashtech.nashtech_shop.entity.Product;

import com.nashtech.nashtech_shop.model.dto.ProductDTO;

import com.nashtech.nashtech_shop.reponsitory.ProductReponsitory;

import com.nashtech.nashtech_shop.utils.MyConstants;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;


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
            productDTOS = products.map(ProductDTO::ToProductDTO);
        }
        return productDTOS;
    }

    @Override
    public Page<ProductDTO> searchProduct(int pageNumber, String key, int category, int subCategory, int brand, String sort) {
        Page<Product> result = null;
        key = key.trim();
        List<Sort.Order> order = new ArrayList<Sort.Order>();

        if (!sort.equals(" ")) {
            for (String s : MyConstants.SORT_OPERATOR) {
                if (sort.equalsIgnoreCase(s))
                    order.add(new Sort.Order(Sort.Direction.fromString(sort), MyConstants.SORT_COLUM));
            }
        }

        if (brand != -1) {
            result = productReponsitory
                    .getProductsByBrandId(PageRequest.of(pageNumber, MyConstants.PAGE_SIZE, Sort.by(order)), "%" + key + "%", subCategory);
        } else if (subCategory != -1) {
            result = productReponsitory
                    .getProductsBySubID(PageRequest.of(pageNumber, MyConstants.PAGE_SIZE, Sort.by(order)), "%" + key + "%", subCategory);
        } else if (category != -1) {
            result = productReponsitory
                    .getProductsByCategory(PageRequest.of(pageNumber, MyConstants.PAGE_SIZE, Sort.by(order)), category, "%" + key + "%");

        } else {
            result = productReponsitory
                    .findProductsByName(PageRequest.of(pageNumber, MyConstants.PAGE_SIZE, Sort.by(order)), "%" + key + "%");
        }

        return result.map(ProductDTO::ToProductDTO);

    }

    @Override
    public Page<ProductDTO> filterProductByStatus(int pageNumber, String key, int category, int subCategory, int brand, int status) {

        Page<Product> result = null;
        key = key.trim();
        List<Sort.Order> order = new ArrayList<Sort.Order>();

        try {

            if (status == -1) {
                return searchProduct(pageNumber, key, category, subCategory, brand, "");
            }
            if (brand != -1) {
                result = productReponsitory
                        .getProductsByBrandIdAndStatus(PageRequest.of(pageNumber, MyConstants.PAGE_SIZE), "%" + key + "%", subCategory, status);
            } else if (subCategory != -1) {
                result = productReponsitory
                        .getProductsBySubIDAndStatus(PageRequest.of(pageNumber, MyConstants.PAGE_SIZE), "%" + key + "%", subCategory, status);
            } else if (category != -1) {
                result = productReponsitory
                        .getProductsByCategoryAndStatus(PageRequest.of(pageNumber, MyConstants.PAGE_SIZE), category, "%" + key + "%", status);

            } else {
                result = productReponsitory
                        .getProductsByStatusAndKey(PageRequest.of(pageNumber, MyConstants.PAGE_SIZE), "%" + key + "%", status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.map(ProductDTO::ToProductDTO);

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
    public ProductDTO updateProduct(Long id, Product product) {
        Product productEntity = productReponsitory.findById(id).get();
        if (productEntity == null) {
            return null;
        } else {
            productEntity = product;
            productReponsitory.deleteById(id);
            productReponsitory.save(productEntity);
            return ProductDTO.ToProductDTO(productEntity);
        }
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
