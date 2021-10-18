package com.nashtech.nashtech_shop.Service;

import com.nashtech.nashtech_shop.entity.Product;
import com.nashtech.nashtech_shop.model.dto.ProductDTO;
import com.nashtech.nashtech_shop.model.dto.ProductImageDTO;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public interface ProductService {
    public Page<ProductDTO> findAll(Pageable page ) ;
    public Page<ProductDTO> searchProduct(int pageNumber , String key  , int  category , int  subCategory , int brand , String Sort ) ;
    public Page<ProductDTO> filterProductByStatus(int pageNumber , String key  , int  category , int  subCategory , int brand , int StatusID ) ;

    public ProductDTO findById (Long id) ;
    public ProductDTO createProduct(Product product) ;
    public ProductDTO updateProduct(Long id , Product product) ;
    public ProductDTO deleteProduct(Long id );



}
