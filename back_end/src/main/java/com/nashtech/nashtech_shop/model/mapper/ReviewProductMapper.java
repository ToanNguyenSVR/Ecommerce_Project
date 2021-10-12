package com.nashtech.nashtech_shop.model.mapper;


import com.nashtech.nashtech_shop.entity.Product;
import com.nashtech.nashtech_shop.entity.ReviewProduct;
import com.nashtech.nashtech_shop.model.dto.ReviewProductDTO;

public class ReviewProductMapper {

    public ReviewProductDTO ToReviewProductDTO (ReviewProduct reviewProduct){
        ReviewProductDTO reviewProductDTO = new ReviewProductDTO();
        reviewProductDTO.setId(reviewProduct.getId());
        reviewProductDTO.setContent(reviewProduct.getContent());


        return reviewProductDTO ;
    }



}
