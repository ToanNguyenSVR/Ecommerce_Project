package com.nashtech.nashtech_shop.APIController.publicAPI;

import com.nashtech.nashtech_shop.Service.ProductService;
import com.nashtech.nashtech_shop.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductAPI {
    @Autowired
    ProductService productService;
    private int page_size;

    @RequestMapping(value = "/toann/public/api/product", method = RequestMethod.GET)
    public ResponseEntity<?> getProduct(@RequestParam(name = "page", defaultValue = "1") Integer page) {
       if(page <= 0 ){
           return ResponseEntity.notFound().build();
       }
        final int page_size = 20;
        Page<ProductDTO> products;
        products = productService.findAll(PageRequest.of(page - 1 , page_size));
        if (products.getTotalElements() <= 0) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(products);
        }

    }

}
