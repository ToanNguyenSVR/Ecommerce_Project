package com.nashtech.nashtech_shop.Service;

import com.nashtech.nashtech_shop.entity.Product;
import com.nashtech.nashtech_shop.model.dto.ProductDTO;
import com.nashtech.nashtech_shop.model.dto.ProductImageDTO;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public interface ProductService {
    public List<ProductDTO> findAll() ;
    public List<ProductDTO> searchProduct(String key  , Map<String, Integer > value ) ;


    public ProductDTO findById (Long id) ;
    public ProductDTO createProduct(Product product) ;
    public ProductDTO updateProduct( Product product) ;
    public ProductDTO deleteProduct(Long id );



}
