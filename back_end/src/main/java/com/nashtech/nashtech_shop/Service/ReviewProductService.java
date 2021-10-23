package com.nashtech.nashtech_shop.Service;

import com.nashtech.nashtech_shop.entity.ReviewProduct;
import com.nashtech.nashtech_shop.model.dto.ReviewProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewProductService {
    public List<ReviewProductDTO> getByProductID(Long id);

    public ReviewProductDTO update(Long id, String content);

    public ReviewProductDTO createReview(ReviewProductDTO review , Long UserID  , Long productId , int startID );

    public  ReviewProductDTO delete(Long id );
}
