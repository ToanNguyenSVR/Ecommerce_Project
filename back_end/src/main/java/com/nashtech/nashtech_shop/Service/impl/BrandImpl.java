package com.nashtech.nashtech_shop.Service.impl;

import com.nashtech.nashtech_shop.Service.BrandService;
import com.nashtech.nashtech_shop.entity.Brand;
import com.nashtech.nashtech_shop.model.dto.BrandDTO;
import com.nashtech.nashtech_shop.reponsitory.BrandReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BrandImpl implements BrandService {
    @Autowired
    BrandReponsitory brandReponsitory ;

    @Override
    public List<BrandDTO> findAll() {
        List<Brand> brands =  brandReponsitory.findAll() ;
        if(brands == null ){
            return null ;
        }
        return brands.stream().map(BrandDTO::ToBrandDTO).collect(Collectors.toList());
    }

    @Override
    public BrandDTO findById(int id) {
        if(id == -1 ){
            return null ;
        }
        return BrandDTO.ToBrandDTO(brandReponsitory.findById(id));
    }

    @Override
    public Boolean delete(int id) {
        Brand brand = brandReponsitory.getById(id);
        Boolean result = false ;
        if(brand != null ){
            brandReponsitory.deleteById(id);
            result = true ;

        }
        return result;
    }

    @Override
    public BrandDTO updateBrand(int id ,  String name ) {
        Brand brand = brandReponsitory.findById(id);
        if(brand != null ){
            brand.setName(name);
            brandReponsitory.save(brand);
        }
        return BrandDTO.ToBrandDTO(brand);
    }

    @Override
    public BrandDTO addProToBrand(int id, List<Long> proID) {
        return null;
    }

}
