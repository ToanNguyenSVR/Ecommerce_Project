package com.nashtech.nashtech_shop.Service.impl;

import com.nashtech.nashtech_shop.Service.PromotionService;
import com.nashtech.nashtech_shop.entity.Product;
import com.nashtech.nashtech_shop.entity.Promotion;
import com.nashtech.nashtech_shop.entity.StatusPromotion;
import com.nashtech.nashtech_shop.model.dto.PromotionDTO;
import com.nashtech.nashtech_shop.reponsitory.ProductReponsitory;
import com.nashtech.nashtech_shop.reponsitory.PromotionReponsitory;
import com.nashtech.nashtech_shop.reponsitory.StatusPromotionReponsitory;
import com.nashtech.nashtech_shop.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    PromotionReponsitory promotionReponsitory;

    @Autowired
    StatusPromotionReponsitory statusPromotionReponsitory;

    @Autowired
    ProductReponsitory productReponsitory;

    @Override
    public List<PromotionDTO> findALl() {
        return promotionReponsitory.findAll().stream().map(PromotionDTO::ToPromotionDTO).collect(Collectors.toList());
    }

    @Override
    public PromotionDTO findByID(Long id) {
        return PromotionDTO.ToPromotionDTO(promotionReponsitory.findById(id).get());
    }

    @Override
    public PromotionDTO updatePromotion(Long id, Map<String, String> value) {
        PromotionDTO result = null;
        Promotion promotion;
        boolean haveValue = false;
        promotion = promotionReponsitory.getById(id);
        for (String property : MyUtils.promotionProperty) {
            if (value.containsKey(property)) {
                haveValue = true;
            }
        }
        if (haveValue) {
            result = updatePromotion(promotion, value);
        }
        return result;
    }

    private PromotionDTO updatePromotion(Promotion promotion, Map<String, String> value) throws NumberFormatException {
        PromotionDTO result = null;
        boolean updated = false;

        try {
            for (String property : value.keySet()) {
              String swichValue  = property.toLowerCase();
                switch (swichValue) {
                    case "title":
                        promotion.setTitle(value.get(property));
                        updated = true;
                        break;
                    case "decription":
                        promotion.setDecription(value.get(property));
                        updated = true;
                        break;
                    case "imageurl":
                        promotion.setImageUrl(value.get(property));
                        updated = true;
                        break;
                    case "percent":
                        int percent = Integer.parseInt(value.get(property));
                        if(0>percent || percent>100){
                            throw new NumberFormatException();
                        }
                        promotion.setPercent(Integer.parseInt(value.get(property)));
                        updated = true;
                        break;
                    case "statuspromotion":
                        int statusId = Integer.parseInt(value.get(property));
                        StatusPromotion statusPromotion = statusPromotionReponsitory.getById(statusId);
                        promotion.setStatusPromotion(statusPromotion);
                        updated = true;
                        break;
                    case "enddate":
                        promotion.setEndDate(value.get(property));
                        updated = true;
                        break;

                }

            }
            if (updated) {

                result = PromotionDTO.ToPromotionDTO(promotionReponsitory.save(promotion));
            }
        } catch (NumberFormatException nf) {
            throw nf;
        }


        return result;
    }

    @Override
    public PromotionDTO createPromotion(PromotionDTO promotion) {
        Promotion value;
        PromotionDTO result = null;
        StatusPromotion statusPromotion;
        try {
            statusPromotion = statusPromotionReponsitory.findByStatus(MyUtils.Active);
            if(promotion.getPercent()>100 || promotion.getPercent()<0){
                throw new NumberFormatException();
            }
            value = new Promotion(null,
                    promotion.getTitle(),
                    promotion.getDecription(),
                    promotion.getImageUrl(),
                    promotion.getPercent(),
                    promotion.getStartDate(),
                    promotion.getEndDate(),
                    statusPromotion,
                    null);
            result = PromotionDTO.ToPromotionDTO(promotionReponsitory.save(value));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public PromotionDTO delete(Long id) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        Promotion promotion;
        PromotionDTO result = null;

        StatusPromotion statusPromotion = statusPromotionReponsitory.findByStatus(MyUtils.UnActive);
        promotion = promotionReponsitory.getById(id);
        promotion.setStatusPromotion(statusPromotion);
        promotion.setEndDate(formatter.format(date));
        result = PromotionDTO.ToPromotionDTO(promotionReponsitory.save(promotion));


        return result;
    }

    @Override
    public PromotionDTO addProductToEvent(Long id, List<Long> productIds) {
        Promotion promotion;
        PromotionDTO result = null;
        List<Product> products = null;
        if (id != -1) {
            promotion = promotionReponsitory.getById(id);
            products = promotion.getProducts();
            if (products == null) {
                products = new ArrayList<>();
            }
            if (!productIds.isEmpty()) {
                for (Long productId : productIds) {
                    Product product = productReponsitory.getById(productId);
                    product.setPromotion(promotion);
                    product = productReponsitory.save(product);
                    products.add(product);
                }
                promotion.setProducts(products);
                result = PromotionDTO.ToPromotionDTO(promotionReponsitory.save(promotion));
            }
        }
        return result;
    }
}
