package com.nashtech.nashtech_shop.model.dto;


import com.nashtech.nashtech_shop.entity.Product;
import com.nashtech.nashtech_shop.entity.ReviewProduct;
import com.nashtech.nashtech_shop.entity.Star;
import lombok.Data;

import javax.persistence.*;


@Data
public class ReviewProductDTO {

    private Long id ;

    private String content ;

    public ReviewProductDTO ToReviewProductDTO (ReviewProduct reviewProduct){
        ReviewProductDTO reviewProductDTO = new ReviewProductDTO();
        reviewProductDTO.setId(reviewProduct.getId());
        reviewProductDTO.setContent(reviewProduct.getContent());


        return reviewProductDTO ;
    }




}
