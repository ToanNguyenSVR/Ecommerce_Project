package com.nashtech.nashtech_shop.APIController.API;

import com.nashtech.nashtech_shop.APIController.exceptionHandler.APIHandlerException;
import com.nashtech.nashtech_shop.Service.ProductService;

import com.nashtech.nashtech_shop.model.ErrorMessage;
import com.nashtech.nashtech_shop.model.dto.ProductDTO;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
@RestController
public class ProductAPI {
    @Autowired
    ProductService productService;

    private int page_size;

    @RequestMapping(value = "/toan/admin/api/1.0/product/create" , method = RequestMethod.POST)
    public ResponseEntity<?> createProduct(
            @RequestBody ProductDTO productDTO , String[] productImageDTO) {
        ProductDTO product = null ;
        try{
            product = productService.createProduct(productDTO ,productImageDTO );
        }catch (Exception e ){
            return ResponseEntity.ok(APIHandlerException.BadRequestException2());
        }finally {
            return ResponseEntity.ok(product);
        }


    }
    @RequestMapping(value = "/toan/admin/api/1.0/product/{id}/update" , method = RequestMethod.PUT)
    public ResponseEntity<?> updateProduct(@PathVariable Long id ,
                                           @RequestBody Map<String, String> productImageDTO) {
        ProductDTO product = null ;
        ErrorMessage errorMessage = new ErrorMessage(0 , " ");
        try{
            product = productService.updateProduct(id , productImageDTO );
            if(product == null ){
                errorMessage.setMessage("Can't update product ");
                errorMessage.setStatusCode(400);
                return ResponseEntity.ok(errorMessage);
            }
            return ResponseEntity.ok(product);
        }catch (Exception e ){
            return ResponseEntity.ok(APIHandlerException.BadRequestException2());
        }
    }
    @DeleteMapping(value ="/toan/admin/api/1.0/product/{id}/delete")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id ) {
        ProductDTO product = null ;
        ErrorMessage errorMessage = new ErrorMessage(0 , " ");
        try{
            product = productService.deleteProduct(id );
            if(product == null ){
                errorMessage.setMessage("Can't delete product ");
                errorMessage.setStatusCode(400);
                return ResponseEntity.ok(errorMessage);
            }
            return ResponseEntity.ok(product);
        }catch (Exception e ){
            return ResponseEntity.ok(APIHandlerException.BadRequestException2());
        }
    }

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
        typeSearch.put(searchBy.toLowerCase().trim() , valueId);
        products = productService.searchProduct( key , typeSearch );
        if (products != null  && products.size() > 0  ) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.ok(APIHandlerException.NotFoundException("Product Not Exist"));
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
