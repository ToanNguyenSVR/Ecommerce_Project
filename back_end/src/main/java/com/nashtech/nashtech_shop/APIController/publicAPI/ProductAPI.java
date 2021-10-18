package com.nashtech.nashtech_shop.APIController.publicAPI;

import com.nashtech.nashtech_shop.APIController.exceptionHandler.APIHandlerException;
import com.nashtech.nashtech_shop.Service.ProductService;

import com.nashtech.nashtech_shop.model.dto.ProductDTO;

import com.nashtech.nashtech_shop.reponsitory.ProductReponsitory;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@RestController
public class ProductAPI {
    @Autowired
    ProductService productService;
    private int page_size;

    @RequestMapping(value = "/toann/public/api/1.0/products", method = RequestMethod.GET)
    public ResponseEntity<?> getProduct(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        if (page <= 0) {
            return ResponseEntity.ok(APIHandlerException.NotFoundException("Page " + page + " Not Exist "));
        }
        final int page_size = 20;
        Page<ProductDTO> products;
        products = productService.findAll(PageRequest.of(page - 1, page_size));
        if (products.getTotalElements() <= 0) {

            return ResponseEntity.ok(APIHandlerException.NotFoundException(" Product Not Exist"));
        } else {
            return ResponseEntity.ok(products);
        }

    }

    @RequestMapping(value = "/toann/public/api/1.0/products/search", method = RequestMethod.GET)
    public ResponseEntity<?> searchProduct(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                           @RequestParam(name = "categoryId", defaultValue = "-1") Integer categoryId,
                                           @RequestParam(name = "subCategoryId", defaultValue = "-1") Integer subCategoryId,
                                           @RequestParam(name = "brandId", defaultValue = "-1") Integer brandId,
                                           @RequestParam(name = "key", defaultValue = " ") String key ,
                                           @RequestParam(name = "sort" ,defaultValue = " ") String sort) {
        if (page <= 0) {
            return ResponseEntity.ok(APIHandlerException.NotFoundException("Page " + page + " Not Exist "));
        }
        final int page_size = 20;
        Page<ProductDTO> products;
        products = productService.searchProduct(page -1 , key, categoryId, subCategoryId , brandId , sort );
        if (products.getTotalElements() <= 0) {
            return ResponseEntity.ok(APIHandlerException.NotFoundException(" Product Not Exist"));
        } else {
            return ResponseEntity.ok(products);
        }

    }

    @RequestMapping(value = "/toann/public/api/1.0/products/filter", method = RequestMethod.GET)
    public ResponseEntity<?> filterProductByStatus(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                           @RequestParam(name = "categoryId", defaultValue = "-1") Integer categoryId,
                                           @RequestParam(name = "subCategoryId", defaultValue = "-1") Integer subCategoryId,
                                           @RequestParam(name = "brandId", defaultValue = "-1") Integer brandId,
                                           @RequestParam(name = "key", defaultValue = " ") String key ,
                                           @RequestParam(name = "statusID" ,defaultValue = "-1") Integer status) {
        if (page <= 0) {
            return ResponseEntity.ok(APIHandlerException.NotFoundException("Page " + page + " Not Exist "));
        }
        final int page_size = 20;
        Page<ProductDTO> products;
        products = productService.filterProductByStatus(page -1 , key, categoryId, subCategoryId , brandId , status );
        if (products.getTotalElements() <= 0) {
            return ResponseEntity.ok(APIHandlerException.NotFoundException(" Product Not Exist"));
        } else {
            return ResponseEntity.ok(products);
        }

    }





    @RequestMapping(value = "/toan/public/api/1.0/product/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> viewDetail(@PathVariable(name = "id") Long id) {
        ProductDTO productDTO = null;
        if (id == null) {
            return ResponseEntity.ok(APIHandlerException.NotFoundException("Product Not found "));
        } else {
            productDTO = productService.findById(id);
        }
        return ResponseEntity.ok(productDTO);
    }



}
