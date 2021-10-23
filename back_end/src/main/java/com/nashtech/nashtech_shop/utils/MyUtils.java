package com.nashtech.nashtech_shop.utils;

import com.nashtech.nashtech_shop.APIController.exceptionHandler.APIHandlerException;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyUtils {

    public static final String[] searchType = {
            "Category",
            "SubCategory",
            "Brand",
            "Promotion"
    };
    public static final String[] productProperty = {

            "subcategory",
            "brand",
            "name",
            "price",
            "decription",
            "image",
            "quantity",
            "promotion"


    };
    public static final String[] promotionProperty = {

            "title",
            "decription",
            "imageUrl",
            "percent",
            "statusPromotion",
            "endDate"
    };
    public static final String UnActive = "UNACTIVE";
    public static final String Active = "ACTIVE";
    public static final Integer StatusNew = 1;
    public static final Integer StatusTOPSELLER = 2;
    public static final Integer StatusDefaut = 3;
    public static final Integer StatusDelete = 4;

    public static final String regex = ":";


    public static Map<String, String> convertValueToMap(List<String> valuesInput) {
        Map<String, String> valuesOutput = null;
        for (String value : valuesInput) {
            String[] s = value.split(regex);
            if (!s[0].equalsIgnoreCase(" ") && s.length == 2) {
                if (valuesOutput == null) {
                    System.out.println(s[1]);
                    valuesOutput = new HashMap<>();
                    valuesOutput.put(s[0], s[1]);
                } else {
                    valuesOutput.put(s[0], s[1]);
                }
            }
        }
        return valuesOutput;
    }


}
