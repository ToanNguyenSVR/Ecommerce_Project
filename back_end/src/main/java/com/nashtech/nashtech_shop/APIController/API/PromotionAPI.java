package com.nashtech.nashtech_shop.APIController.API;

import com.nashtech.nashtech_shop.APIController.exceptionHandler.APIHandlerException;
import com.nashtech.nashtech_shop.Service.ProductService;
import com.nashtech.nashtech_shop.Service.PromotionService;
import com.nashtech.nashtech_shop.model.dto.PromotionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RestControllerAdvice
public class PromotionAPI {
    @Autowired
    PromotionService promotionService;
    @RequestMapping(value = "/toan/public/api/1.0/promotions" , method = RequestMethod.GET)
    public ResponseEntity getPromotions(){
        return ResponseEntity.ok(promotionService.findALl());
    }
    @RequestMapping(value = "/toan/public/api/1.0/promotion/{id}" , method = RequestMethod.GET)
    public ResponseEntity getPromotion(@PathVariable Long id){
        return ResponseEntity.ok(promotionService.findByID(id));
    }
    @RequestMapping(value = "/toan/admin/api/1.0/promotion/{id}/update" , method = RequestMethod.PUT)
    public ResponseEntity updatePromotion(@PathVariable Long id , @RequestBody Map<String, String> value){
        PromotionDTO result = null ;
        try {
            result = promotionService.updatePromotion(id, value);
            if(result!= null ){
                return ResponseEntity.ok(result);
            }else{
                return ResponseEntity.ok(APIHandlerException.NotFoundException("Can't update Promotion: "+ id));
            }
        }catch (Exception e ){
            return ResponseEntity.ok(APIHandlerException.BadRequestException2());
        }

    }
    @RequestMapping(value = "/toan/admin/api/1.0/promotion/create" , method = RequestMethod.POST)
    public ResponseEntity createPromotion( @RequestBody PromotionDTO promotionDTO){
        PromotionDTO result = null ;
        try {
            result = promotionService.createPromotion(promotionDTO);
            if(result!= null ){
                return ResponseEntity.ok(result);
            }else{
                return ResponseEntity.ok(APIHandlerException.NotFoundException("Can't create Promotion: "));
            }
        }catch (Exception e ){
            return ResponseEntity.ok(APIHandlerException.BadRequestException2());
        }

    }
    @RequestMapping(value = "/toan/admin/api/1.0/promotion/{id}/delete" , method = RequestMethod.DELETE)
    public ResponseEntity deletePromotion( @PathVariable Long id){
        PromotionDTO result = null ;
        try {
            result = promotionService.delete(id);
            if(result!= null ){
                return ResponseEntity.ok( result);
            }else{
                return ResponseEntity.ok(APIHandlerException.NotFoundException("Can't delete Promotion: "));
            }
        }catch (Exception e ){
            return ResponseEntity.ok(APIHandlerException.BadRequestException2());
        }

    }
    @RequestMapping(value = "/toan/admin/api/1.0/promotion/{id}/addProduct" , method = RequestMethod.PUT)
    public ResponseEntity addProductToPromotion( @PathVariable Long id , @RequestBody List<Long> productIds){
        PromotionDTO result = null ;
        try {
            result = promotionService.addProductToEvent(id,productIds);
            if(result!= null ){
                return ResponseEntity.ok("added " + result);
            }else{
                return ResponseEntity.ok(APIHandlerException.NotFoundException("Can't add product to  Promotion: " + id ));
            }
        }catch (NumberFormatException e ){
            return ResponseEntity.ok(APIHandlerException.BadRequestException2());
        }

    }
}
