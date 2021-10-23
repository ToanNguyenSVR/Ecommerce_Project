package com.nashtech.nashtech_shop.Service;

import com.nashtech.nashtech_shop.entity.Brand;
import com.nashtech.nashtech_shop.model.dto.BrandDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public  interface BrandService {
    public List<BrandDTO> findAll();
    public BrandDTO findById(int id );
    public Boolean delete(int id );
    public BrandDTO updateBrand(int id ,  String  value );
    public BrandDTO addProToBrand(int id ,  List<Long> proID );
    public  BrandDTO createBrand(String brandName);


}
