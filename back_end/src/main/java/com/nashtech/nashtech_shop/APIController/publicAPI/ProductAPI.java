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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
@RestController
public class ProductAPI {
    @Autowired
    ProductService productService;
    private int page_size;

    @RequestMapping(value = "/toann/public/api/1.0/products", method = RequestMethod.GET)
    public ResponseEntity<?> getProduct() {


        List<ProductDTO> products = null ;
        products = productService.findAll();
        if (products!= null && products.size() > 0) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.ok(APIHandlerException.NotFoundException(" Product Not Exist"));
        }

    }

    @RequestMapping(value = "/toann/public/api/1.0/products/search", method = RequestMethod.GET)
    public ResponseEntity<?> searchProduct( @RequestParam(name = "key", defaultValue = "") String key ,
                                            @RequestParam(name = "searchBy" , defaultValue = "") String searchBy ,
                                            @RequestParam(name = "valueid" , defaultValue =  "-1") Integer valueId
                                        ) {
        List<ProductDTO> products;
        Map<String , Integer > typeSearch  = new HashMap<>();
        typeSearch.put(searchBy.toLowerCase() , valueId);
        products = productService.searchProduct( key , typeSearch );
        if (products.size() > 0) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.ok(APIHandlerException.NotFoundException(" Product Not Exist"));
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
