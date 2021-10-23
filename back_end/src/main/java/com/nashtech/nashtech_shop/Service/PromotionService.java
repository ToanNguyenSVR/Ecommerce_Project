package com.nashtech.nashtech_shop.Service;


import com.nashtech.nashtech_shop.model.dto.PromotionDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface PromotionService {
    public List<PromotionDTO> findALl ();
    public PromotionDTO findByID(Long id );
    public PromotionDTO updatePromotion(Long id , Map<String , String > value )throws  NumberFormatException;
    public  PromotionDTO createPromotion(PromotionDTO promotion);
    public  PromotionDTO delete(Long id);
    public  PromotionDTO addProductToEvent ( Long id , List<Long> productIds );
}
