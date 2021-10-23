package com.nashtech.nashtech_shop.Service.impl;

import com.nashtech.nashtech_shop.Service.ReviewProductService;
import com.nashtech.nashtech_shop.entity.Account;
import com.nashtech.nashtech_shop.entity.Product;
import com.nashtech.nashtech_shop.entity.ReviewProduct;
import com.nashtech.nashtech_shop.entity.Star;
import com.nashtech.nashtech_shop.model.dto.ReviewProductDTO;
import com.nashtech.nashtech_shop.reponsitory.AccountReponsitory;
import com.nashtech.nashtech_shop.reponsitory.ProductReponsitory;
import com.nashtech.nashtech_shop.reponsitory.ReviewProductReponsitory;
import com.nashtech.nashtech_shop.reponsitory.StarReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ReviewProductServiceImpl implements ReviewProductService {
    @Autowired
    ReviewProductReponsitory reviewProductReponsitory ;
    @Autowired
    AccountReponsitory accountReponsitory ;
    @Autowired
    ProductReponsitory productReponsitory ;
    @Autowired
    StarReponsitory starReponsitory;


    @Override
    public List<ReviewProductDTO> getByProductID(Long id) {
        return reviewProductReponsitory.findByProductsId(id).stream().map(ReviewProductDTO::ToReviewProductDTO).collect(Collectors.toList());
    }

    @Override
    public ReviewProductDTO update(Long reviewId, String content) {
        ReviewProductDTO result = null ;
        ReviewProduct reviewProduct ;
        try{
            reviewProduct = reviewProductReponsitory.getById(reviewId);
            reviewProduct.setContent(content);
            result = ReviewProductDTO.ToReviewProductDTO(reviewProductReponsitory.save(reviewProduct));
        }catch (Exception e ){
           throw e ;
        }


        return result;
    }

    @Override
    public ReviewProductDTO createReview(ReviewProductDTO review , Long UserID  , Long productId , int startID )  {
      try{
          Account account = accountReponsitory.getById(UserID);
          Product product = productReponsitory.getById(productId);
          Star star = starReponsitory.getById(startID);
          ReviewProduct reviewProduct = new ReviewProduct(null , review.getContent() , account , star , product );
          return  ReviewProductDTO.ToReviewProductDTO(reviewProductReponsitory.save(reviewProduct));
      }catch (Exception e){
          throw  e ;
      }

    }

    @Override
    public ReviewProductDTO delete(Long id) {
        // chưa làm tại vì còn dính tới nhiều vấn đề như xóa nhầm là cm

        return null;
    }
}
