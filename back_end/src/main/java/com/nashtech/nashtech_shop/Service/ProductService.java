package com.nashtech.nashtech_shop.Service;

import com.nashtech.nashtech_shop.entity.Product;
import com.nashtech.nashtech_shop.model.dto.ProductDTO;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public Page<ProductDTO> findAll(Pageable page ) ;
    public Page<ProductDTO> searchProduct(Pageable Page , String name , String category) ;
    public ProductDTO createProduct(Product product) ;
    public ProductDTO updateProduct(Long id , Product product) ;
    public ProductDTO deleteProduct(Long id );

}
