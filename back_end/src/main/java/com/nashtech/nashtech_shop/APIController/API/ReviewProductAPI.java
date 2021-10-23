package com.nashtech.nashtech_shop.APIController.API;

import com.nashtech.nashtech_shop.Service.ReviewProductService;
import com.nashtech.nashtech_shop.model.dto.ReviewProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
@RestController
public class ReviewProductAPI {

    @Autowired
    ReviewProductService reviewProductService;

    @RequestMapping(value = "/toan/public/api/1.0/product/review/{id}" ,method = RequestMethod.GET)
    public ResponseEntity getReview(@PathVariable Long id){
        return ResponseEntity.ok(reviewProductService.getByProductID(id));
    }
    @RequestMapping(value = "/toan/auth/api/1.0/review/{id}/update" ,method = RequestMethod.PUT)
    public ResponseEntity updateReview(@PathVariable Long id , @RequestBody String content){
        return ResponseEntity.ok(reviewProductService.update(id, content));
    }
    @RequestMapping(value = "/toan/auth/api/1.0/product/review/create" ,method = RequestMethod.POST)
    public ResponseEntity ceateReview(@RequestBody ReviewProductDTO review , Integer startId , Long userId , Long productId){
        return ResponseEntity.ok(reviewProductService.createReview(review,userId , productId , startId));
    }
//    @RequestMapping(value = "/toan/public/api/1.0/product/review/{id}" ,method = RequestMethod.GET)
//    public ResponseEntity getReview(@PathVariable Long id){
//        return ResponseEntity.ok(reviewProductService.getByProductID(id));
//    }
}
