package com.nashtech.nashtech_shop.model.dto;


import com.nashtech.nashtech_shop.entity.ReviewProduct;
import lombok.Data;


@Data
public class ReviewProductDTO {

    private Long id ;

    private String content ;

    private  String userName ;

    private  String userImage ;

    public static ReviewProductDTO ToReviewProductDTO (ReviewProduct reviewProduct){
        ReviewProductDTO reviewProductDTO = new ReviewProductDTO();
        reviewProductDTO.setId(reviewProduct.getId());
        reviewProductDTO.setContent(reviewProduct.getContent());
        reviewProductDTO.setUserName(reviewProduct.getAccount().getEmail());
        reviewProductDTO.setUserImage(reviewProduct.getAccount().getImageUrl());
        return reviewProductDTO ;
    }




}
