package com.nashtech.nashtech_shop.APIController.publicAPI;

import com.nashtech.nashtech_shop.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryAPI {

    @Autowired
    CategoryService categoryService ;
    @RequestMapping(value = "/toann/public/api/1.0/categories" , method = RequestMethod.GET)
    public ResponseEntity<?> getCategory(){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

}
